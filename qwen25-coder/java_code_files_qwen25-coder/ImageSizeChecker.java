import java.lang.String;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageSizeChecker {

    public static boolean isImageWithinDimensions(String imageUrl, int maxWidth, int maxHeight) {
        try (InputStream is = new URL(imageUrl).openStream()) {
            // Read the image from the input stream
            Image image = ImageIO.read(is);
            if (image != null) {
                // Get dimensions of the image
                int width = image.getWidth(null);
                int height = image.getHeight(null);

                // Check if the image meets the specified dimensions criteria
                return width <= maxWidth && height <= maxHeight;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Return false in case of any error or if image cannot be read
    }

    public static void main(String[] args) {
        String imageUrl = "http://example.com/your-image.jpg";
        int maxWidth = 800;
        int maxHeight = 600;

        boolean isWithinDimensions = isImageWithinDimensions(imageUrl, maxWidth, maxHeight);
        System.out.println("Is the image within dimensions? " + isWithinDimensions);
    }
}