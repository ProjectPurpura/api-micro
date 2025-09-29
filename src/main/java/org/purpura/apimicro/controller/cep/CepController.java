package org.purpura.apimicro.controller.cep;

import org.purpura.apimicro.dto.cep.CepResponseDTO;
import org.purpura.apimicro.service.CepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cep")
public class CepController implements CepContract {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @Override
    public Mono<CepResponseDTO> getCep(@PathVariable String cep) {
        return cepService.fetch(cep);
    }

    @Override
    public Mono<Boolean> isValid(@PathVariable String cep) {
        return cepService.isValid(cep);
    }
}
