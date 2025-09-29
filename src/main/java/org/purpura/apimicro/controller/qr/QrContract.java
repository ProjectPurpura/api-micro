package org.purpura.apimicro.controller.qr;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.purpura.apimicro.dto.qr.QrCodeRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface QrContract {

    @Operation(summary = "Gerar um QR Code", description = "Retorna uma imagem bruta (bytes) contendo um QR Code com base na chave informada",
        responses = {
            @ApiResponse(responseCode = "200", description = "Imagem do QR Code retornada com sucesso",
                content = @Content(mediaType = MediaType.IMAGE_PNG_VALUE)
            )
        }
    )
    @PostMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    byte[] generate(@RequestBody @Valid QrCodeRequestDTO qrCodeRequestDTO);

}
