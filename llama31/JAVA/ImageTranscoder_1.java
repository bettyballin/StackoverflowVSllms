import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class ImageTranscoder_1_1 {
    String jpegUrl = "https://example.com/image.jpg";
    byte[] pngBytes = ImageTranscoder_1.jpegToPng(jpegUrl);

    public static byte[] jpegToPng(String jpegUrl) throws IOException {
        URL url = new URL(jpegUrl);
        InputStream is = url.openStream();
        BufferedImage image = ImageIO.read(is);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        return bos.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        ImageTranscoder_1 transcoder = new ImageTranscoder_1();
        // Do something with the resulting bytes
    }
}