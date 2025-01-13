import java.io.File;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {
    public static void main(String[] args) {
        String text = "https://example.com";
        int width = 300;
        int height = 300;
        String format = "png";
        File outputFile = new File("qrcode.png");

        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);

            MatrixToImageWriter.writeToPath(matrix, format, outputFile.toPath());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}