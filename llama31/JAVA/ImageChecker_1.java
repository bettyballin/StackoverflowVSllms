import java.lang.String;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageChecker_1 {
    public static boolean checkImageDimensions(String url, int expectedWidth, int expectedHeight) throws IOException {
        URL imageUrl = new URL(url);
        BufferedImage image = ImageIO.read(imageUrl);
        int width = image.getWidth();
        int height = image.getHeight();
        return width == expectedWidth && height == expectedHeight;
    }

	public static void main(String[] args) {
	}
}