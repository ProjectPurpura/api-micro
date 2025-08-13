package org.purpura.apimicro.model.qr;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String foregroundHex;

    @NotNull(message = "A cor do background não pode ser nula")
    @NotBlank(message = "A cor do background não pode ser vazia")
    @Pattern(
            regexp = "^#([A-Fa-f0-9]{6})$",
            message = "A cor do background deve estar no formato HEX (#RRGGBB)"
    )
    private String backgroundHex;
}
