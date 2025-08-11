package org.purpura.apimicro.controller;

import org.purpura.apimicro.model.cep.CepResponse;
import org.purpura.apimicro.service.CepService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/cep")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping
    public Mono<CepResponse> getCep(String cep) {
        return cepService.getCep(cep);
    }
}
