import java.lang.String;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageComparator {
    public static void main(String[] args) throws IOException {
        BufferedImage original = ImageIO.read(new File("original.jpg"));
        BufferedImage output = ImageIO.read(new File("output.jpg"));

        int width = original.getWidth();
        int height = original.getHeight();

        BufferedImage difference = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int origPixel = original.getRGB(x, y);
                int outputPixel = output.getRGB(x, y);

                if (origPixel != outputPixel) {
                    difference.setRGB(x, y, 0xFF0000); // Mark difference as red
                } else {
                    difference.setRGB(x, y, 0x000000); // Mark identical pixels as black
                }
            }
        }

        ImageIO.write(difference, "png", new File("difference.png"));
    }
}