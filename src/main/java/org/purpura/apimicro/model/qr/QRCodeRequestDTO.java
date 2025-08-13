package org.purpura.apimicro.model.qr;

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
public class QRCodeRequestDTO {

    @NotNull(message = "A chave não pode ser nula")
    @NotBlank(message = "A chave não pode ser vazia")
    private String key;

    @NotNull(message = "A cor do foreground não pode ser nula")
    @NotBlank(message = "A cor do foreground não pode ser vazia")
    @Pattern(
            regexp = "^#([A-Fa-f0-9]{6})$",
            message = "A cor do foreground deve estar no formato HEX (#RRGGBB)"
    )
    private String foregroundHex = Colors.DEFAULT_FORE_QR_COLOR;

    @NotNull(message = "A cor do background não pode ser nula")
    @NotBlank(message = "A cor do background não pode ser vazia")
    @Pattern(
            regexp = "^#([A-Fa-f0-9]{6})$",
            message = "A cor do background deve estar no formato HEX (#RRGGBB)"
    )
    private String backgroundHex = Colors.DEFAULT_BACK_QR_COLOR;


    @NotNull(message = "O tamanho do QR code deve ser diferente de nulo")
    @Positive(message = "O tamanho do QR code deve ser maior que zero")
    private int size = Sizes.DEFAULT_QR_SIZE;
}
