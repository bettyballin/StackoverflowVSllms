import java.lang.String;
import javax.imageio.*;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import java.awt.image.BufferedImage;
import java.io.File;

public class GifToJpgConverter {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("C:/abc.gif"));
            
            // Locate an ImageWriter that supports the "jpg" format
            ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
            
            // Configure and create a new IIOImage with the provided BufferedImage
            ImageWriteParam param = writer.getDefaultWriteParam();
            if (param.canWriteCompressed()){
                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(1.0f); // 1.0 means no compression
            }
            
            // Prepare to write the image to a file
            File outputFile = new File("C:/abc.jpg");
            writer.setOutput(ImageIO.createImageOutputStream(outputFile));
            IIOImage outputImage = new IIOImage(image, null, null);
            writer.write(null, outputImage, param);
            writer.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}