import java.lang.String;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Color;

public class ImageRotator {
    public Image rotateImage(BufferedImage image, int angle) {
        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));

        int w = (int)(image.getWidth() * cos + image.getHeight() * sin);
        int h = (int)(image.getHeight() * cos + image.getWidth() * sin);

        BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) result.getGraphics();
        AffineTransform at = AffineTransform.getTranslateInstance(
            (w - image.getWidth()) / 2, (h - image.getHeight()) / 2);
        at.rotate(rads, image.getWidth() / 2.0, image.getHeight() / 2.0);
        g.setColor(new Color(0.0f, 0.0f, 0.0f));
        g.fillRect(0, 0, w, h);
        at.rotate(-rads, image.getWidth() / 2.0, image.getHeight() / 2.0);
        g.setTransform(at);
        g.drawImage(image, 0, 0, null);

        return result;
    }

    public static void main(String[] args) {
    }
}