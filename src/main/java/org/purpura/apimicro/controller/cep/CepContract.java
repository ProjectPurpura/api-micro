package org.purpura.apimicro.controller.cep;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.purpura.apimicro.dto.cep.CepResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

public interface CepContract {
    @Operation(summary = "Busca as informações de um CEP", description = "Retorna as informações detalhadas de um CEP",
        responses = {
            @ApiResponse(responseCode = "200", description = "Dados do CEP retornados com sucesso",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CepResponseDTO.class))
            ),
            @ApiResponse(responseCode = "400", description = "CEP inválido")
        }
    )
    @GetMapping("/{cep}")
    Mono<CepResponseDTO> getCep(@PathVariable
                                @Parameter(name = "cep", description = "CEP a ser procurado (sem hífen)", example = "77403175")
                                String cep);

    @Operation(summary = "Verifica se um CEP (sem hífens) é válido", description = "Retorna um booleano para se um CEP é valido",
        responses = {
            @ApiResponse(responseCode = "200", description = "true se CEP válido false senão",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Boolean.class))
            )
        }
    )
    @GetMapping("/{cep}/is_valid")
    Mono<Boolean> isValid(@PathVariable
                          @Parameter(name = "cep", description = "CEP a ser validado (com hífen)", example = "77403-175")
                          String cep);
}
