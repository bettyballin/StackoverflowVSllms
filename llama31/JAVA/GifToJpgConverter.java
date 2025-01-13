import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

public class GifToJpgConverter {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("C:/abc.gif"));
            JPEGImageWriteParam param = new JPEGImageWriteParam(null);
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(1f); // highest quality
            ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
            writer.setOutput(new FileImageOutputStream(new File("C:/abc.jpg")));
            writer.write(null, new IIOImage(image, null, null), param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}