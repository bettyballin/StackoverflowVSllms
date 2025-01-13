import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

import org.w3c.dom.Element;

import com.sun.imageio.plugins.jpeg.JPEGImageWriter;

public class Main_544 {
    public static boolean saveJpeg(int[] byteArray, int width, int height, int dpi, String file) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        WritableRaster wr = bufferedImage.getRaster();
        wr.setPixels(0, 0, width, height, byteArray);

        try {
            // Image writer
            JPEGImageWriter imageWriter = (JPEGImageWriter) ImageIO.getImageWritersBySuffix("jpeg").next();
            ImageOutputStream ios = ImageIO.createImageOutputStream(new File(file));
            imageWriter.setOutput(ios);

            // Compression
            JPEGImageWriteParam jpegParams = (JPEGImageWriteParam) imageWriter.getDefaultWriteParam();
            jpegParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(0.85f);

            // Metadata (dpi)
            IIOMetadata data = imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(bufferedImage), jpegParams);
            Element tree = (Element) data.getAsTree("javax_imageio_jpeg_image_1.0");
            Element jfif = (Element) tree.getElementsByTagName("app0JFIF").item(0);
            jfif.setAttribute("Xdensity", Integer.toString(dpi));
            jfif.setAttribute("Ydensity", Integer.toString(dpi));
            jfif.setAttribute("resUnits", "1"); // density is dots per inch

            // Merge the modified metadata back into the IIOMetadata object
            data.mergeTree("javax_imageio_jpeg_image_1.0", tree);

            // Write and clean up
            imageWriter.write(data, new IIOImage(bufferedImage, null, null), jpegParams);
            ios.close();
            imageWriter.dispose();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Example usage
        int[] byteArray = new int[100 * 100]; // Replace with your image data
        int width = 100;
        int height = 100;
        int dpi = 300;
        String file = "output.jpg";
        boolean success = saveJpeg(byteArray, width, height, dpi, file);
        System.out.println("Image saved successfully: " + success);
    }
}