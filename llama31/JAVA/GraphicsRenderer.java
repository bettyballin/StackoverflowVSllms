import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class GraphicsRenderer {
    public static void main(String[] args) {
        // Create a BufferedImage
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

        // Create a Graphics2D object once
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        // Create shapes
        Shape shape1 = new Ellipse2D.Float(100, 100, 200, 200);
        Shape shape2 = new Ellipse2D.Float(300, 300, 200, 200);
        Shape shape3 = new Ellipse2D.Float(500, 100, 200, 200);

        // Reuse the Graphics2D object for multiple rendering operations
        g2d.draw(shape1);
        g2d.draw(shape2);
        g2d.draw(shape3);

        // Dispose of the Graphics2D object when finished
        g2d.dispose();
    }
}