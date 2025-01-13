/*
 * Decompiled with CFR 0.152.
 */
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageTransitionEffect {
    public static void main(String[] stringArray) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("old_image.png"));
        BufferedImage bufferedImage2 = ImageIO.read(new File("new_image.png"));
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 0.9f));
        graphics2D.drawImage((Image)bufferedImage2, 0, 0, null);
        for (int i = 0; i <= 10; ++i) {
            float f = (float)i / 10.0f;
            graphics2D.setComposite(AlphaComposite.getInstance(3, f));
            graphics2D.drawImage((Image)bufferedImage2, 0, 0, null);
            ImageIO.write((RenderedImage)bufferedImage, "png", new File("transition_" + i + ".png"));
        }
    }
}
