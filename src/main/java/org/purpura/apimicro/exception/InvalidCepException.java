package org.purpura.apimicro.exception;

public class InvalidCepException extends RuntimeException {

    public InvalidCepException(String cep) {
        super(String.format("Invalid CEP: %s", cep));
    }
}
