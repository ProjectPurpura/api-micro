package org.purpura.apimicro.service.qr;

import org.purpura.apimicro.exception.QrGenerationException;
import org.purpura.apimicro.model.qr.QrCodeRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class QrCodeService {
    public byte[] generate(QrCodeRequestDTO qrCodeRequestDTO) {
        try {
            return QrCodeGenerator.generateQRCode(qrCodeRequestDTO);
        } catch (Exception e) {
            throw new QrGenerationException(e.getMessage());
        }
    }
}
