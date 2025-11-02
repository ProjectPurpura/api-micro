package org.purpura.apimicro.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.purpura.apimicro.config.redis.RedisKeys;
import org.purpura.apimicro.dto.remote.ViaCepResponse;
import org.purpura.apimicro.exception.CouldNotFetchCepException;
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
    private final ObjectMapper objectMapper;

    private static final String CEP_URL = "https://viacep.com.br/ws/";


    public CepService(WebClient.Builder webClientbuilder, ObjectMapper objectMapper) {
        this.webClient = webClientbuilder.baseUrl(CEP_URL).build();
        this.objectMapper = objectMapper;
    }

    public Mono<ViaCepResponse> nonCachedFetch(String cep) {
        String cleanedCep = cep == null ? "" : cep.replaceAll("[^0-9]", "");
        if (cleanedCep.length() != 8) {
            return Mono.error(new InvalidCepException(cep));
        }
        return webClient.get()
                .uri("{cep}/json/", cleanedCep)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> response.bodyToMono(String.class).map(InvalidCepException::new))
                .bodyToMono(String.class)
                .flatMap(body -> {
                    try {
                        if (body == null || body.isEmpty()) {
                            return Mono.error(new CouldNotFetchCepException(cep));
                        }
                        JsonNode node = objectMapper.readTree(body);
                        if (node.has("erro") && node.get("erro").asBoolean(false)) {
                            return Mono.error(new InvalidCepException(cep));
                        }
                        ViaCepResponse resp = objectMapper.treeToValue(node, ViaCepResponse.class);
                        return Mono.just(resp);
                    } catch (InvalidCepException ex) {
                        return Mono.error(ex);
                    } catch (Exception ex) {
                        return Mono.error(new CouldNotFetchCepException(cep));
                    }
                });
    }

    @Cacheable(value = RedisKeys.CEP_CACHE, key = "#p0", unless = "#result == null")
    public Mono<CepResponseDTO> fetch(String cep) {
        return nonCachedFetch(cep)
                .map(remoteResponse -> {
                    CepResponseDTO responseDTO = new CepResponseDTO();
                    BeanUtils.copyProperties(remoteResponse, responseDTO);
                    return responseDTO;
                })
                .switchIfEmpty(Mono.error(new CouldNotFetchCepException(cep)));
    }

    @Cacheable(value = RedisKeys.CEP_VALID_CACHE, key = "#p0", unless = "#result == null")
    public Mono<Boolean> isValid(String cep) {
        return nonCachedFetch(cep)
                .flatMap(response -> Mono.just(true))
                .onErrorResume(InvalidCepException.class, ex -> Mono.just(false))
                .onErrorResume(ex -> Mono.just(false));
    }
}
