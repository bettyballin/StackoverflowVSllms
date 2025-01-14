import java.lang.String;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImageTranscoder {
    public static void main(String[] args) {
        try {
            // URL of the JPEG image you want to download
            URL url = new URL("http://example.com/sample.jpg");
            
            // Read the image from the URL into a BufferedImage object
            BufferedImage image = ImageIO.read(url);
            
            // Create a byte array output stream to hold the PNG data
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] imageData = baos.toByteArray();

            System.out.println("Image converted and available as a byte array.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}