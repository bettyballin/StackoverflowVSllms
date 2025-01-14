import java.lang.String;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverter {
    public static void main(String[] args) throws IOException {
        // Load JPEG file
        File input = new File("path/to/your/image.jpg");
        BufferedImage image = ImageIO.read(input);

        if (image == null) {
            System.out.println("Failed to read input file.");
            return;
        }

        // Save as TIFF file
        File output = new File("path/to/output/image.tiff");
        boolean result = ImageIO.write(image, "tiff", output);

        if (!result) {
            System.out.println("Failed to write output file.");
        } else {
            System.out.println("Conversion successful!");
        }
    }
}