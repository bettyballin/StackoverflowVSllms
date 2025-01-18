import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.lang.Math;

public class ResizeBarcode {

    public static void main(String[] args) {

        // Your existing BufferedImage with barcode
        BufferedImage original = getOriginalBufferedImage();

        double scaleFactor = 300/72d;
        int newWidth = (int)Math.ceil(original.getWidth() * scaleFactor);
        int newHeight = (int)Math.ceil(original.getHeight() * scaleFactor);
        BufferedImage resizedBarcode = new BufferedImage(newWidth, newHeight, original.getType());
        Graphics2D g = resizedBarcode.createGraphics();
        try {
            AffineTransform at = AffineTransform.getScaleInstance(scaleFactor, scaleFactor);
            g.drawRenderedImage(original, at);
        } finally {
            g.dispose();
        }
    }

    private static BufferedImage getOriginalBufferedImage() {
        // Placeholder method to provide the original BufferedImage
        // In practice, you would obtain the BufferedImage from your source
        return new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
    }
}