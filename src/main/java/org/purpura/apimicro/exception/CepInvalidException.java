package org.purpura.apimicro.exception;

public class CepInvalidException extends RuntimeException {

    public CepInvalidException(String cep) {
        super(String.format("Invalid CEP: %s", cep));
    }
}
