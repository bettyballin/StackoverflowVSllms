/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static void main(String[] stringArray) throws IOException {
        InputStream inputStream = ImageLoader.class.getClassLoader().getResourceAsStream("assets/pacman.png");
        BufferedImage bufferedImage = ImageIO.read(inputStream);
    }
}
