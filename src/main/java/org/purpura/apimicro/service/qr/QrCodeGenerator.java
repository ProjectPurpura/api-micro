package org.purpura.apimicro.service.qr;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.purpura.apimicro.common.Colors;
import org.purpura.apimicro.dto.qr.QrCodeRequestDTO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class QrCodeGenerator {

    public static final String PNG_FORMAT = "png";

    public static byte[] generateQRCode(String text, int width, int height, Color foreground, Color background) throws Exception {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix = new MultiFormatWriter()
                .encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        // Convert to BufferedImage with custom colors
        BufferedImage qrImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                qrImage.setRGB(x, y, bitMatrix.get(x, y) ? foreground.getRGB() : background.getRGB());
            }
        }

        // Convert BufferedImage to byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(qrImage, PNG_FORMAT, baos);
        return baos.toByteArray();
    }

    public static byte[] generateQRCode(QrCodeRequestDTO qrCodeRequestDTO) throws Exception {
        return generateQRCode(
                qrCodeRequestDTO.getKey(),
                qrCodeRequestDTO.getSize(),
                qrCodeRequestDTO.getSize(),
                Colors.fromHex(qrCodeRequestDTO.getForegroundHex()),
                Colors.fromHex(qrCodeRequestDTO.getBackgroundHex())
        );
    }
}
