import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class LargeImageCreator {
    public static void main(String[] args) throws Exception {
        int width = 10000; // Very large width
        int height = 10000; // Very large height

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // Set background color
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // Draw something on the image
        g.setColor(Color.WHITE);
        g.drawString("Check", 100, 100);

        g.dispose();
        File output = new File("large_image.jpg");
        ImageIO.write(image, "jpg", output);
    }
}