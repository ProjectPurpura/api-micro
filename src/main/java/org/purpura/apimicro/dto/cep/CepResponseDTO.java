package org.purpura.apimicro.dto.cep;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "CepResponseDTO", description = "DTO para resposta de um CEP")
public class CepResponseDTO {
    @Schema(description = "Código postal brasileiro no formato 00000-000", example = "01001-000")
    @JsonProperty("cep")
    private String cep;

    @Schema(description = "Nome da rua, avenida, travessa ou similar", example = "Praça da Sé")
    @JsonProperty("logradouro")
    private String logradouro;

    @Schema(description = "Informações adicionais sobre o endereço", example = "lado ímpar")
    @JsonProperty("complemento")
    private String complemento;

    @Schema(description = "Nome do bairro", example = "Sé")
    @JsonProperty("bairro")
    private String bairro;

    @Schema(description = "Nome da cidade", example = "São Paulo")
    @JsonProperty("localidade")
    private String localidade;

    @Schema(description = "Sigla do estado", example = "SP")
    @JsonProperty("uf")
    private String uf;
}