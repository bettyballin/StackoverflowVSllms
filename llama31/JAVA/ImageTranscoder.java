import java.lang.String;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImageTranscoder {
    public static byte[] jpegToPng(String jpegUrl) throws IOException {
        URL url = new URL(jpegUrl);
        BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        return bos.toByteArray();
    }

	public static void main(String[] args) {
	}
}