package org.purpura.apimicro.exception;

public class QrGenerationException extends RuntimeException {
    public QrGenerationException(String message) {
        super("Erro ao gerar QR code:" + message);
    }
}
