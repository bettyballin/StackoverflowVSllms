import java.awt.image.*;
import java.io.*;
import java.util.Iterator;
import javax.imageio.*;
import javax.imageio.stream.*;
import javax.imageio.ImageWriter;
import javax.imageio.IIOImage;

public class ImageConverter {

    public void convertJpegToTiff(String jpegFilePath, String tiffFilePath) {
        try (FileInputStream fis = new FileInputStream(jpegFilePath)) {
            BufferedImage image = ImageIO.read(fis);
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("TIFF");

            if (!writers.hasNext()) {
                throw new IllegalStateException("No appropriate writer is found for TIFF format.");
            }

            ImageWriter writer = writers.next();
            try (FileOutputStream fos = new FileOutputStream(tiffFilePath);
                 ImageOutputStream outputStream = ImageIO.createImageOutputStream(fos)) {
                writer.setOutput(outputStream);
                IIOImage iioimage = new IIOImage(image, null, null);
                writer.write(null, iioimage, writer.getDefaultWriteParam());
            } finally {
                writer.dispose();
            }
        } catch (IOException e) {
            // Handle exception accordingly...
        }
    }
}