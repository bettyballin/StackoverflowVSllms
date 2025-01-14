import java.lang.String;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageTranscoder_1 {
    public static void main(String[] args) {
        try {
            // URL of the JPEG image you want to download
            URL url = new URL("http://example.com/sample.jpg");
            
            // Read the image from the URL into a BufferedImage object
            BufferedImage image = ImageIO.read(url);
            
            // Write the BufferedImage as a PNG file to a byte array output stream
            File outputFile = new File("output.png");
            ImageIO.write(image, "png", outputFile);

            System.out.println("Image converted and saved as PNG.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}