import java.lang.String;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageChecker {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://example.com/image.jpg"); // replace with your image URL
        BufferedImage bufferedImage = ImageIO.read(url);

        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
}