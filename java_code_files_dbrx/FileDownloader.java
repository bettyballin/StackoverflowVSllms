import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownloader {
    public static void main(String[] args) {
        String imageUrl = "http://example.com/path/to/image.jpg"; // Replace with actual URL

        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(imageUrl).openStream());
             FileOutputStream fileOS = new FileOutputStream("path_to_save/file.jpg")) {

            byte[] buf = new byte[1024];
            int n;
            while ((n = inputStream.read(buf)) > 0) {
                fileOS.write(buf, 0, n);
            }
        } catch (IOException e) {
            // handle exception as per your requirement.
            e.printStackTrace();
        }
    }
}