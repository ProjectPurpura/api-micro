package org.purpura.apimicro.service;

import org.purpura.apimicro.exception.InvalidCepException;
import org.purpura.apimicro.model.cep.CepResponseDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CepService {
    private final WebClient webClient;

    private static final String CEP_URL = "https://viacep.com.br/ws/";


    public CepService(WebClient.Builder webClientbuilder) {
        this.webClient = webClientbuilder.baseUrl(CEP_URL).build();
    }


    public Mono<CepResponseDTO> fetch(String cep) {
        String cleanedCep = cep.replaceAll("[^0-9]", "");
        return webClient.get()
                .uri("{cep}/json/", cleanedCep)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> response.bodyToMono(String.class).map(InvalidCepException::new))
                .bodyToMono(CepResponseDTO.class)
                .flatMap(response -> {
                    if (response.isErro()) {
                        return Mono.error(new InvalidCepException(cep));
                    }
                    return Mono.just(response);
                });
    }

    public Mono<Boolean> isValid(String cep) {
        try {
            return fetch(cep).map(response -> !response.isErro());
        } catch (InvalidCepException ex) {
            return Mono.just(false);
        }
    }
}
