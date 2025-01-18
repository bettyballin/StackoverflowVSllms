import java.io.IOException;
import java.nio.file.Paths;
import com.google.zxing.WriterException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator_1 {
    public static void generateQR(String data, String path) throws WriterException, IOException {
        int width = 300;
        int height = 300;
        BitMatrix matrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToPath(matrix, "PNG", Paths.get(path));
    }

    public static void main(String[] args) {
    }
}