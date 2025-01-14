import java.lang.String;

// Example using Gzip in Java
import java.util.zip.GZIPOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class FileCompressor {
    public static void compress(String fromFile, String toFile) throws Exception {
        try (GZIPOutputStream gzipOS = new GZIPOutputStream(new FileOutputStream(toFile));
             FileInputStream fis = new FileInputStream(fromFile)) {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, n);
            }
        }
    }
    public static void main(String[] args) {
    }
}