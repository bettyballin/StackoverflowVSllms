import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WriteImage {
    public static void main(String[] args) throws IOException {
        // Read an image from file (replace "input_image.jpg" with your image file)
        BufferedImage src = ImageIO.read(new File("input_image.jpg"));

        // Write the same source image as PNG (lossless format)
        ImageIO.write(src, "png", new File("output_image.png")); // Write the same source image as PNG (lossless format)
    }
}