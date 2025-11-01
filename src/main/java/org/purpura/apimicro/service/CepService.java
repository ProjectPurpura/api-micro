package org.purpura.apimicro.service;

import org.purpura.apimicro.dto.remote.ViaCepResponse;
import org.purpura.apimicro.exception.CouldNotFetchCEPException;
import org.purpura.apimicro.exception.InvalidCepException;
import org.purpura.apimicro.dto.cep.CepResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CepService {
    private final WebClient webClient;

    private static final String CEP_URL = "https://viacep.com.br/ws/";
    private static final String CEP_CACHE = "cep";
    private static final String CEP_VALID_CACHE = "cep:valid";


    public CepService(WebClient.Builder webClientbuilder) {
        this.webClient = webClientbuilder.baseUrl(CEP_URL).build();
    }

    public Mono<ViaCepResponse> nonCachedFetch(String cep) {
        String cleanedCep = cep.replaceAll("[^0-9]", "");
        return webClient.get()
                .uri("{cep}/json/", cleanedCep)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> response.bodyToMono(String.class).map(InvalidCepException::new))
                .bodyToMono(ViaCepResponse.class)
                .flatMap(response -> {
                    if (response.getErro() != null) {
                        return Mono.error(new InvalidCepException(cep));
                    }
                    return Mono.just(response);
                });
    }

    @Cacheable(value = CEP_CACHE, key = "#cep")
    public Mono<CepResponseDTO> fetch(String cep) {
        ViaCepResponse remoteResponse = nonCachedFetch(cep).block();
        if (remoteResponse == null) {
            throw new CouldNotFetchCEPException(cep);
        }
        CepResponseDTO responseDTO = new CepResponseDTO();

        BeanUtils.copyProperties(remoteResponse, responseDTO);
        return Mono.just(responseDTO);
    }

    @Cacheable(value = CEP_VALID_CACHE, key = "#cep", unless = "#result == false")
    public Mono<Boolean> isValid(String cep) {
        try {
            return nonCachedFetch(cep).map(response -> !response.getErro());
        } catch (InvalidCepException ex) {
            return Mono.just(false);
        }
    }
}
