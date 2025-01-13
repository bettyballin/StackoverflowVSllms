import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class ImageLoader {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = ImageLoader.class.getClassLoader().getResourceAsStream("assets/pacman.png");
        Image image = ImageIO.read(inputStream);
    }
}