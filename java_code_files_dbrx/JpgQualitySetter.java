import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.IIOImage;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class JpgQualitySetter {
    public static void main(String[] args) throws IOException {
        // Set JPG Quality before writing the image
        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpeg");
        if (!iter.hasNext()) {
            throw new IllegalStateException("No encoder for jpeg format");
        }
        ImageWriter imageWriter = iter.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(new File(args[1]));
        imageWriter.setOutput(ios);
    
        // Set JPG quality to be relatively high; this will result in less lossy compression artifacts, but a larger file size
        BufferedImage src = ImageIO.read(new File(args[0]));
        IIOImage image = new IIOImage(src, null, null);
        ImageWriteParam param = imageWriter.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.95f); // Set quality to 0.95 (this is not a percentage value)
        imageWriter.write(null, image, param);
        ios.close();
    }
}