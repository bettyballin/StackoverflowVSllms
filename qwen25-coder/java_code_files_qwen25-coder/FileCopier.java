import java.lang.String;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class FileCopier {
    // Start with a 16KB buffer size (adjust based on your testing results)
    private static final int BUFFER_SIZE = 16 * 1024; // 16 KB

    public static void main(String[] args) {
        // Main method implementation
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) {
        try (BufferedInputStream bis = new BufferedInputStream(inputStream, BUFFER_SIZE);
             BufferedOutputStream bos = new BufferedOutputStream(outputStream, BUFFER_SIZE)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Handle exception
        }
    }
}