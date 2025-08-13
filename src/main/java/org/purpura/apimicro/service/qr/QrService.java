package org.purpura.apimicro.service.qr;

import org.purpura.apimicro.exception.QrGenerationException;
import org.purpura.apimicro.model.qr.QRCodeRequestDTO;

public class QrService {
    public byte[] generate(QRCodeRequestDTO qrCodeRequestDTO) {
        try {
            return QrCodeGenerator.generateQRCode(qrCodeRequestDTO);
        } catch (Exception e) {
        throw new QrGenerationException(e.getMessage());
        }
    }
}
