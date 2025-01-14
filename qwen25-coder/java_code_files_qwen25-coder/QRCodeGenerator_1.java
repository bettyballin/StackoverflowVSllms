import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QRCodeGenerator_1 {
    private static final int SIZE = 250;
    private static final String IMAGE_FORMAT = "png";

    public static void generateQR(String content, String filePath) throws WriterException, IOException {
        // Define hints for encoding
        Map<EncodeHintType, Object> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // Generate BitMatrix
        MultiFormatWriter mwObject = new MultiFormatWriter();
        BitMatrix bitMatrix = mwObject.encode(content, BarcodeFormat.QR_CODE, SIZE, SIZE, hintMap);

        // Convert to BufferedImage and write to file
        BufferedImage image = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? -16777216 : -1); // Black and White
            }
        }
        File file = new File(filePath);
        ImageIO.write(image, IMAGE_FORMAT, file);
    }

    public static void main(String[] args) {
        try {
            generateQR("Hello, World!", "HelloWorld-QR.png");
            System.out.println("QR Code generated successfully.");
        } catch (WriterException | IOException e) {
            System.err.println(e);
        }
    }
}