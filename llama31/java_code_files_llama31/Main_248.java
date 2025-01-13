/*
 * Decompiled with CFR 0.152.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

public class Main_248 {
    public static void main(String[] stringArray) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(100, 100, 1);
        ImageWriter imageWriter = ImageIO.getImageWritersByFormatName("jpeg").next();
        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
        imageWriteParam.setCompressionMode(2);
        imageWriteParam.setCompressionQuality(0.8f);
        IIOImage iIOImage = new IIOImage(bufferedImage, null, null);
        imageWriter.setOutput(new FileImageOutputStream(new File("output.jpg")));
        imageWriter.write(null, iIOImage, imageWriteParam);
        imageWriter.dispose();
    }
}
