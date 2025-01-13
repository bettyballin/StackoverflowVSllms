import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ConcatenateJPEGImages {
    public static void main(String[] args) {
        try {
            // Load the two JPEG images
            BufferedImage imageA = ImageIO.read(new File("imageA.jpg"));
            BufferedImage imageB = ImageIO.read(new File("imageB.jpg"));

            // Create a new BufferedImage that is the correct size
            int width = imageA.getWidth() + imageB.getWidth();
            int height = Math.max(imageA.getHeight(), imageB.getHeight());
            BufferedImage concatenatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Draw the images onto the new BufferedImage
            Graphics g = concatenatedImage.getGraphics();
            g.drawImage(imageA, 0, 0, null);
            g.drawImage(imageB, imageA.getWidth(), 0, null);
            g.dispose();

            // Save the concatenated image
            ImageIO.write(concatenatedImage, "jpg", new File("output.jpg"));
        } catch (IOException e) {
            System.err.println("Error reading or writing images: " + e.getMessage());
        }
    }
}