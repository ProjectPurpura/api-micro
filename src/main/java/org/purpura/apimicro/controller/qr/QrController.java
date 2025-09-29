package org.purpura.apimicro.controller.qr;

import jakarta.validation.Valid;
import org.purpura.apimicro.dto.qr.QrCodeRequestDTO;
import org.purpura.apimicro.service.qr.QrCodeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/qr")
public class QrController implements QrContract {

    private final QrCodeService qrCodeService;

    public QrController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @Override
    public byte[] generate(@RequestBody @Valid QrCodeRequestDTO qrCodeRequestDTO) {
        return qrCodeService.generate(qrCodeRequestDTO);
    }
}
