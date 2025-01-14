import java.lang.String;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;

import javax.imageio.stream.ImageOutputStream;
import javax.imageio.ImageWriter;

import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class PngWriter {

    public static void main(String[] args) {
        BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        Graphics2D ig2d = bi.createGraphics();
        ig2d.setPaint(Color.WHITE);
        ig2d.fillRect(0, 0, 465, 290);

        try {
            // Write the image with added text metadata
            addTextToPng(bi, "Description", "This is a sample PNG image");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addTextToPng(BufferedImage bi, String keyword, String textValue) throws IOException {
        String format = "png";
        ImageWriter writer = null;
        for (ImageWriter iw : ImageIO.getImageWritersByFormatName(format)) {
            if (!iw.getClass().getName().equals("com.sun.imageio.plugins.png.PNGImageWriter"))
                continue;

            writer = iw;
            break;
        }

        if (writer == null) throw new IOException("Cannot obtain PNG writer");

        ImageOutputStream ios = null;

        try {
            IIOMetadata metadata = writer.getDefaultImageMetadata(
                    ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_ARGB),
                    writer.getDefaultWriteParam());

            String nativeFormatName = metadata.getNativeMetadataFormatName();
            Node tree = metadata.getAsTree(nativeFormatName);
            Node textEntry = findTextEntry(tree, keyword);

            if (textEntry == null) {
                IIOMetadataNode textEntries = new IIOMetadataNode("tEXt");
                IIOMetadataNode textNode = new IIOMetadataNode("tEXtEntry");
                textNode.setAttribute("keyword", keyword);
                textNode.setAttribute("value", textValue);
                textEntries.appendChild(textNode);
                tree.appendChild(textEntries);
            } else {
                IIOMetadataNode iioTextNode = (IIOMetadataNode) textEntry;
                iioTextNode.setAttribute("value", textValue);
            }

            metadata.setFromTree(nativeFormatName, tree);

            ImageWriteParam writeParams = writer.getDefaultWriteParam();
            IIOImage imageWithMetadata = new IIOImage(bi, null, metadata);

            ios = ImageIO.createImageOutputStream(new File("output_tmp.png"));
            writer.setOutput(ios);
            writer.write(null, imageWithMetadata, writeParams);
            ios.flush();

        } finally {
            if (ios != null) {
                ios.close();
            }
            if (writer != null) {
                writer.dispose();
            }
        }
    }

    private static Node findTextEntry(Node root, String keyword) {
        for (Node node = root.getFirstChild(); node != null; node = node.getNextSibling()) {
            if ("tEXt".equals(node.getNodeName())) {
                for (Node entry = node.getFirstChild(); entry != null; entry = entry.getNextSibling()) {
                    if (entry instanceof IIOMetadataNode) {
                        IIOMetadataNode iioNode = (IIOMetadataNode) entry;
                        String key = iioNode.getAttribute("keyword");
                        if (keyword.equals(key)) {
                            return entry;
                        }
                    }
                }
            }
        }
        return null;
    }
}