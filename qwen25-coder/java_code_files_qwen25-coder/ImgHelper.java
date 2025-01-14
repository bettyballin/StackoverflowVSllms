import java.lang.String;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImgHelper {
    public Image loadImage(String filename) throws IOException {
        // Use getClass().getClassLoader() to get resource from JAR file or classpath
        URL imgURL = getClass().getClassLoader().getResource("assets/" + filename);
        if (imgURL == null) {
            throw new IllegalArgumentException("Resource not found: " + filename);
        } else {
            return ImageIO.read(imgURL);
        }
    }

	public static void main(String[] args) {
	}
}