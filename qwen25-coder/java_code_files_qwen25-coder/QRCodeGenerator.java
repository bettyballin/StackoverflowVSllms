// Ensure the ZXing library is in your classpath when compiling.

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeGenerator {
    public static void main(String[] args) throws WriterException {
        String qrData = "https://www.example.com";
        int qrSize = 300; // dimension of the QR code
        BitMatrix matrix = new MultiFormatWriter().encode(qrData, BarcodeFormat.QR_CODE, qrSize, qrSize);
        System.out.println("QR Code generated");
    }
}