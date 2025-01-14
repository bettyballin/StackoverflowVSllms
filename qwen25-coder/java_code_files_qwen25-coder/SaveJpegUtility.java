import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.ImageWriter;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;

import org.w3c.dom.Node;

public class SaveJpegUtility {

    public boolean saveJpeg(int[] byteArray, int width, int height, int dpi, String file) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        WritableRaster wr = bufferedImage.getRaster();
        wr.setPixels(0, 0, width, height, byteArray);

        try {
            // Image writer
            ImageWriter imageWriter = ImageIO.getImageWritersBySuffix("jpeg").next();
            ImageOutputStream ios = ImageIO.createImageOutputStream(new File(file));
            imageWriter.setOutput(ios);

            // Compression
            ImageWriteParam jpegParams = imageWriter.getDefaultWriteParam();

            if (jpegParams.canWriteCompressed()) {
                jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                jpegParams.setCompressionQuality(0.85f);
            }

            // Metadata (dpi)
            IIOMetadata data = imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(bufferedImage), jpegParams);

            if (!data.isStandardMetadataFormatSupported()) {
                System.out.println("Standard metadata format not supported!");
                return false;
            }

            // Modify metadata to include dpi
            String metadataFormat = "javax_imageio_jpeg_image_1.0";
            IIOMetadataNode root = (IIOMetadataNode) data.getAsTree(metadataFormat);

            IIOMetadataNode jfif = getChildNode(root, "app0JFIF");

            if (jfif == null) {
                // Create the node
                IIOMetadataNode jfifVariety = new IIOMetadataNode("JPEGvariety");
                jfif = new IIOMetadataNode("app0JFIF");
                jfifVariety.appendChild(jfif);
                root.appendChild(jfifVariety);
            }

            jfif.setAttribute("Xdensity", Integer.toString(dpi));
            jfif.setAttribute("Ydensity", Integer.toString(dpi));
            jfif.setAttribute("resUnits", "1"); // density is dots per inch

            data.mergeTree(metadataFormat, root);

            // Write and clean up
            imageWriter.write(data, new IIOImage(bufferedImage, null, null), jpegParams);
            ios.close();
            imageWriter.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private static IIOMetadataNode getChildNode(Node node, String nodeName) {
        Node childNode = node.getFirstChild();
        while (childNode != null) {
            if (nodeName.equalsIgnoreCase(childNode.getNodeName())) {
                return (IIOMetadataNode) childNode;
            }
            childNode = childNode.getNextSibling();
        }
        return null;
    }
}