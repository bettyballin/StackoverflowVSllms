import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.IOException;

public class ImageEncoder {
    byte[] imageBytes;
    String encodedImage;

    public ImageEncoder() throws IOException {
        imageBytes = Files.readAllBytes(Paths.get("path/to/your-file")); // reads byte array from an existing file as an example
        encodedImage = Base64.getEncoder().encodeToString(imageBytes);  // This is just to provide a simple working example and might not be needed depending on context in OAuth handling
    }

    public static void main(String[] args) {
        try {
            ImageEncoder encoder = new ImageEncoder();
            // You can add code here to use encoder.encodedImage
            System.out.println("Encoded Image: " + encoder.encodedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}