import java.io.*;
import java.util.zip.*;

public class CompressionUtil {
    // Use GZIP compression
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("output.gz");
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
        // Use gzipOutputStream as needed
        gzipOutputStream.close();
    }
}