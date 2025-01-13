import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageProcessor_3_3 {
    public static void main(String[] args) {
        File file = new File("image.jpg");
        try {
            String mimeType = Files.probeContentType(file.toPath());
            if (mimeType.startsWith("image/jpeg") || mimeType.equals("image/pjpeg") || mimeType.equals("image/x-citrix-pjpeg")) {
                // Process the image as a JPEG
                System.out.println("Processing image as JPEG...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}