import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RotateImage {
    public static void main(String[] args) {
        AffineTransform tx = new AffineTransform();
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        tx.rotate(-Math.PI, img.getWidth() / 2, img.getHeight() / 2);  //for 180 degrees rotation
    }
}