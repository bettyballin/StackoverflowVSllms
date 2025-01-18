import java.lang.String;
import java.io.File;
import java.awt.image.BufferedImage;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;

public class BarcodeReader {
    public static void main(String[] args) throws Exception {
        File imageFile = new File("path/to/your/image");
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        MultiFormatReader barcodeReader = new MultiFormatReader();

        Result result = barcodeReader.decode(bitmap);
        System.out.println("Decoded Data: " + result.getText());
    }
}