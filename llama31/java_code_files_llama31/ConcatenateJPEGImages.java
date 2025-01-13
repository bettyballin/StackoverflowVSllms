/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ConcatenateJPEGImages {
    public static void main(String[] stringArray) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("imageA.jpg"));
            BufferedImage bufferedImage2 = ImageIO.read(new File("imageB.jpg"));
            int n = bufferedImage.getWidth() + bufferedImage2.getWidth();
            int n2 = Math.max(bufferedImage.getHeight(), bufferedImage2.getHeight());
            BufferedImage bufferedImage3 = new BufferedImage(n, n2, 1);
            Graphics graphics = bufferedImage3.getGraphics();
            graphics.drawImage(bufferedImage, 0, 0, null);
            graphics.drawImage(bufferedImage2, bufferedImage.getWidth(), 0, null);
            graphics.dispose();
            ImageIO.write((RenderedImage)bufferedImage3, "jpg", new File("output.jpg"));
        }
        catch (IOException iOException) {
            System.err.println("Error reading or writing images: " + iOException.getMessage());
        }
    }
}
