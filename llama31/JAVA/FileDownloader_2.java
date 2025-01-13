import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLConnection;

public class FileDownloader_2_2 {
    public static void main(String[] args) throws Exception {
        URLConnection uc = new URLConnection(null) {
            // This is a placeholder, you should initialize it with a real URLConnection
        };

        try (InputStream in = uc.getInputStream();
             FileOutputStream out = new FileOutputStream("output_file");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            // ...
        }
    }
}