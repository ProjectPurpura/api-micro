package org.purpura.apimicro.dto.remote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// RESPOSTA EXCLUSIVA DA VIA CEP
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViaCepResponse {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private Boolean erro;
}
