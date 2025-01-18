import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class ImageProcessor {
    public static void main(String[] args) throws IOException {
        BufferedImage img = null;

        try {
            File input = new File("input.jpg");
            File output = new File("output.jpg");

            // read image from file
            img = ImageIO.read(input);

            // flip horizontally (around y-axis)
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-img.getWidth(), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            img = op.filter(img, null);

            // rotate by 90 degrees clockwise
            tx.rotate(-Math.PI / 2, img.getWidth() / 2, img.getHeight() / 2);
            op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            BufferedImage rotatedImage = op.filter(img, null);

            // write rotated image back to the output file
            ImageIO.write(rotatedImage, "jpg", output);
        } catch (IOException e) {
            System.out.println("Failed to read or write image.");
            e.printStackTrace();
        }
    }
}