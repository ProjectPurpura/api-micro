package org.purpura.apimicro.controller;

import jakarta.validation.Valid;
import org.purpura.apimicro.model.qr.QrCodeRequestDTO;
import org.purpura.apimicro.service.qr.QrCodeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/qr")
public class QrController {

    private final QrCodeService qrCodeService;

    public QrController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generate(@RequestBody @Valid QrCodeRequestDTO qrCodeRequestDTO) {
        return ResponseEntity.ok(qrCodeService.generate(qrCodeRequestDTO));
    }
}
