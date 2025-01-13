import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main_248 {
    public static void main(String[] args) throws IOException {
        // Assume bufferedImage is a valid BufferedImage object
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

        ImageWriter writer = ImageIO.getImageWritersByFormatName("jpeg").next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.8f);

        IIOImage image = new IIOImage(bufferedImage, null, null);
        writer.setOutput(new FileImageOutputStream(new File("output.jpg")));
        writer.write(null, image, param);
        writer.dispose(); // Dispose the writer to free up resources
    }
}