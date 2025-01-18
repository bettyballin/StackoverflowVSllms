import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageOutputStream;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.metadata.IIOInvalidTreeException;

public class PNGWriter {
    public static void writeImage(BufferedImage bufferedImage, String formatName, File file) throws Exception {
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(formatName);
        ImageWriter imageWriter = writers.next();

        try (ImageOutputStream ios = ImageIO.createImageOutputStream(file)) {
            imageWriter.setOutput(ios);

            // Create custom metadata for tEXt chunk
            IIOMetadata metadata = imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(bufferedImage), null);
            String[] params = new String[]{formatName, "Custom tEXt"};
            setCompressionType(metadata, params);

            // Write the image and metadata to the file
            ImageWriteParam param = imageWriter.getDefaultWriteParam();
            IIOImage iioimage = new IIOImage(bufferedImage, null, metadata);
            imageWriter.write(null, iioimage, param);
        } finally {
            if (imageWriter != null) {
                imageWriter.dispose();
            }
        }
    }

    private static void setCompressionType(IIOMetadata metadata, String[] params) throws IIOInvalidTreeException {
        // Create a new XML node with necessary values and attributes
        IIOMetadataNode textEntry = new IIOMetadataNode("tEXt");
        textEntry.setAttribute("keyword", "Custom-Key");
        textEntry.setAttribute("value", "Custom Value");

        metadata.getAsTree(metadata.getNativeMetadataFormatName()).appendChild(textEntry);
    }

    public static void main(String[] args) {
    }
}