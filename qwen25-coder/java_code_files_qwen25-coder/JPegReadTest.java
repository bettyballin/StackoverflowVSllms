import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.IIOImage;
import javax.imageio.stream.ImageOutputStream;
import java.util.Iterator;

public class JPegReadTest {
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                BufferedImage src = ImageIO.read(new File(args[0]));
                
                // Get a JPEG writer
                Iterator<ImageWriter> writersByFormatName = ImageIO.getImageWritersByFormatName("jpg");
                if (!writersByFormatName.hasNext()) {
                    System.err.println("No Writers found for JPG format!");
                    return;
                }
                ImageWriter writer = writersByFormatName.next();
                ImageWriteParam writeParam = writer.getDefaultWriteParam();
                
                // Set the compression quality
                if (writeParam.canWriteCompressed()){
                    writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    writeParam.setCompressionQuality(1.0f);  // Highest quality
                }

                // Write the image with high quality
                File destinationFile = new File(args[1]);
                ImageOutputStream ios = ImageIO.createImageOutputStream(destinationFile);
                writer.setOutput(ios);
                
                // Ensure using sRGB color space for better accuracy in colors
                BufferedImage dest = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = dest.createGraphics();
                g.drawImage(src, 0, 0, null);
                g.dispose();

                writer.write(null, new IIOImage(dest, null, null), writeParam);

                // Close the output stream
                ios.close();
                writer.dispose();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Usage: java JPegReadTest src dest");
        }
    }
}