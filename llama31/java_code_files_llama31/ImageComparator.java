/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageComparator {
    public static void main(String[] stringArray) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("original.jpg"));
        BufferedImage bufferedImage2 = ImageIO.read(new File("output.jpg"));
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        BufferedImage bufferedImage3 = new BufferedImage(n, n2, 1);
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                int n3;
                int n4 = bufferedImage.getRGB(j, i);
                if (n4 != (n3 = bufferedImage2.getRGB(j, i))) {
                    bufferedImage3.setRGB(j, i, 0xFF0000);
                    continue;
                }
                bufferedImage3.setRGB(j, i, 0);
            }
        }
        ImageIO.write((RenderedImage)bufferedImage3, "png", new File("difference.png"));
    }
}
