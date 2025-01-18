import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Base64;

public class ImageToBase64Converter_1 {
    BufferedImage image = null; // image is your BufferedImage object
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] bytes;
    String base64Image;

    {
        try {
            ImageIO.write(image, "png", baos); // image is your BufferedImage object
            bytes = baos.toByteArray();
            base64Image = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}