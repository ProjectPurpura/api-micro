package org.purpura.apimicro.controller.alive;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.purpura.apimicro.dto.cep.CepResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alive")
public class AliveController {
    @Schema(description = "DTO de resposta para verificação de vida da API", name = "AliveResponseDTO")
    public record AliveResponseDTO(String status, String message) {}


    @Operation(summary = "Verificar API", description = "Verificar se a API está viva",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A api está viva!",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AliveResponseDTO.class))
                    ),
            }
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AliveResponseDTO alive() {
        return new AliveResponseDTO("OK", "API is alive");
    }
}
