/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

public class ImageConverter {
    public static void main(String[] stringArray) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("C:/abc.gif"));
            JPEGImageWriteParam jPEGImageWriteParam = new JPEGImageWriteParam(null);
            jPEGImageWriteParam.setCompressionMode(2);
            jPEGImageWriteParam.setCompressionQuality(1.0f);
            ImageIO.write((RenderedImage)bufferedImage, "jpg", new File("C:/abc.jpg"));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
