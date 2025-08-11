package org.purpura.apimicro.controller;

import org.purpura.apimicro.model.cep.CepResponse;
import org.purpura.apimicro.service.CepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public Mono<CepResponse> getCep(@PathVariable String cep) {
        Mono<CepResponse> response = cepService.getCep(cep);

        return response;
    }
}
