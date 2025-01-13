import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.sun.imageio.plugins.png.PNGMetadata;

public class Main_78 {
    public static void main(String[] args) throws IOException {
        // Replace with your image data
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

        ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();
        PNGMetadata metadata = (PNGMetadata) writer.getDefaultImageMetadata(new javax.imageio.ImageTypeSpecifier(image), null);

        IIOMetadataNode textEntry = new IIOMetadataNode("tEXt");
        textEntry.setAttribute("keyword", "YourKeyword");
        textEntry.setAttribute("value", "YourValue");

        metadata.setText(textEntry);

        ImageOutputStream ios = new FileImageOutputStream(new File("output.png"));
        writer.setOutput(ios);
        writer.write(new javax.imageio.IIOImage(image, null, metadata));
        ios.close();
    }
}