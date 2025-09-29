package org.purpura.apimicro.dto.cep;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CepResponseDTO", description = "DTO para resposta de um CEP")
public class CepResponseDTO {
    @Schema(description = "Código postal brasileiro no formato 00000-000", example = "01001-000")
    private String cep;

    @Schema(description = "Nome da rua, avenida, travessa ou similar", example = "Praça da Sé")
    private String logradouro;

    @Schema(description = "Informações adicionais sobre o endereço", example = "lado ímpar")
    private String complemento;

    @Schema(description = "Nome do bairro", example = "Sé")
    private String bairro;

    @Schema(description = "Nome da cidade", example = "São Paulo")
    private String localidade;

    @Schema(description = "Sigla do estado", example = "SP")
    private String uf;

    @Schema(description = "Código IBGE do município", example = "3550308")
    private String ibge;

    @Schema(description = "Código GIA (específico para endereços do estado de São Paulo)", example = "1004")
    private String gia;

    @Schema(description = "Código DDD da região", example = "11")
    private String ddd;

    @Schema(description = "Código SIAFI do município", example = "7107")
    private String siafi;

    @Schema(description = "Indica se houve erro na consulta", example = "false")
    private boolean erro;
}