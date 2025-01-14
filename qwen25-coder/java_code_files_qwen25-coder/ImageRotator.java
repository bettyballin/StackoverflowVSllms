import java.lang.String;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRotator {
    public static void main(String[] args) throws IOException {
        File input = new File("input.jpg");
        File output = new File("output.jpg");

        BufferedImage image = ImageIO.read(input);
        
        // Determine the rotation angle in degrees
        int rotationAngle = 90; // Change to 180 or 270 as needed

        AffineTransform at = new AffineTransform();
        switch (rotationAngle) {
            case 90:
                at.quadrantRotate(1, image.getWidth() / 2, image.getHeight() / 2);
                break;
            case 180:
                at.quadrantRotate(2, image.getWidth() / 2, image.getHeight() / 2);
                break;
            case 270:
                at.quadrantRotate(3, image.getWidth() / 2, image.getHeight() / 2);
                break;
        }

        BufferedImage rotatedImage = new BufferedImage(
                image.getHeight(),
                image.getWidth(),
                image.getType()
        );

        Graphics2D g2d = (Graphics2D)rotatedImage.getGraphics();
        g2d.setTransform(at);
        g2d.drawImage(image, null, -image.getWidth() / 2, -image.getHeight() / 2);

        ImageIO.write(rotatedImage, "jpg", output);
    }
}