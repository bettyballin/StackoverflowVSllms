import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

public class ImageConverter {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("C:/abc.gif"));
            JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
            jpegParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(1f); // highest quality
            ImageIO.write(image, "jpg", new File("C:/abc.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}