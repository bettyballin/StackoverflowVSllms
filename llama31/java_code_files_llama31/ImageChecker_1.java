/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageChecker_1 {
    public static boolean checkImageDimensions(String string, int n, int n2) throws IOException {
        URL uRL = new URL(string);
        BufferedImage bufferedImage = ImageIO.read(uRL);
        int n3 = bufferedImage.getWidth();
        int n4 = bufferedImage.getHeight();
        return n3 == n && n4 == n2;
    }

    public static void main(String[] stringArray) {
    }
}
