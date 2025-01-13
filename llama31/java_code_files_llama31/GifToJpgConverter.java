/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;

public class GifToJpgConverter {
    public static void main(String[] stringArray) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("C:/abc.gif"));
            JPEGImageWriteParam jPEGImageWriteParam = new JPEGImageWriteParam(null);
            jPEGImageWriteParam.setCompressionMode(2);
            jPEGImageWriteParam.setCompressionQuality(1.0f);
            ImageWriter imageWriter = ImageIO.getImageWritersByFormatName("jpg").next();
            imageWriter.setOutput(new FileImageOutputStream(new File("C:/abc.jpg")));
            imageWriter.write(null, new IIOImage(bufferedImage, null, null), jPEGImageWriteParam);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
