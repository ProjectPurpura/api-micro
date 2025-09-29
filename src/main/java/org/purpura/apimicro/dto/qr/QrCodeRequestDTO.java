package org.purpura.apimicro.dto.qr;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.purpura.apimicro.common.Colors;
import org.purpura.apimicro.common.Sizes;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "QrCodeRequestDTO", description = "DTO para gerar um QR code")
public class QrCodeRequestDTO {

    @NotNull(message = "A chave não pode ser nula")
    @NotBlank(message = "A chave não pode ser vazia")
    @Schema(description = "Chave para gerar o QR code, pode ser qualquer string não vazia", example = "1234567890")
    private String key;

    @NotNull(message = "A cor do foreground não pode ser nula")
    @NotBlank(message = "A cor do foreground não pode ser vazia")
    @Pattern(
            regexp = "^#([A-Fa-f0-9]{6})$",
            message = "A cor do foreground deve estar no formato HEX: #RRGGBB"
    )
    @Schema(description = "Cor da parte interior do QR code em HEX", example = Colors.DEFAULT_FORE_QR_COLOR)
    private String foregroundHex = Colors.DEFAULT_FORE_QR_COLOR;

    @NotNull(message = "A cor do background não pode ser nula")
    @NotBlank(message = "A cor do background não pode ser vazia")
    @Pattern(
            regexp = "^#([A-Fa-f0-9]{6})$",
            message = "A cor do background deve estar no formato HEX: #RRGGBB"
    )
    @Schema(description = "Cor de fundo do QR code em HEX", example = Colors.DEFAULT_BACK_QR_COLOR)
    private String backgroundHex = Colors.DEFAULT_BACK_QR_COLOR;


    @NotNull(message = "O tamanho do QR code deve ser diferente de nulo")
    @Positive(message = "O tamanho do QR code deve ser maior que zero")
    @Schema(description = "Tamanho do QR code em pixels", example = "300")
    private int size = Sizes.DEFAULT_QR_SIZE;
}
