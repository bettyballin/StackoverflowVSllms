/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class GraphicsRenderer {
    public static void main(String[] stringArray) {
        BufferedImage bufferedImage = new BufferedImage(800, 600, 1);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        Ellipse2D.Float float_ = new Ellipse2D.Float(100.0f, 100.0f, 200.0f, 200.0f);
        Ellipse2D.Float float_2 = new Ellipse2D.Float(300.0f, 300.0f, 200.0f, 200.0f);
        Ellipse2D.Float float_3 = new Ellipse2D.Float(500.0f, 100.0f, 200.0f, 200.0f);
        graphics2D.draw(float_);
        graphics2D.draw(float_2);
        graphics2D.draw(float_3);
        graphics2D.dispose();
    }
}
