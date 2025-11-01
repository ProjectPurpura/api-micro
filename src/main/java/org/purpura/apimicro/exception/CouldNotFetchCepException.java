package org.purpura.apimicro.exception;

public class CouldNotFetchCepException extends RuntimeException {
    public CouldNotFetchCepException(String cep) {
        super(String.format("Não foi possível pegar o CEP da api externa %s. Erro de comunicação entre os servidores.", cep));
    }
}
