import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class FileExample_1 {
    public void readFile() {
        String url = "file:///root1/test.txt";
        try {
            URI uri = new URI(url);
            File file = new File(uri);
            if (file.exists()) {
                // Perform operations on the file
            }
            // No need to close the File object
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}