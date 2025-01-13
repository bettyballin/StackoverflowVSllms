import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TextRenderer {
    public static void main(String[] args) {
        // Create a new Graphics2D object
        // NOTE: In a real application, you would typically get a Graphics2D object from a Canvas or Component.
        // For this example, we will just create a new BufferedImage and get its Graphics2D object.
        java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(1, 1, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();

        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    }
}