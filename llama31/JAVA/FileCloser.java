import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCloser {
    public static void closeStream(InputStream fileStream) {
        try {
            if (fileStream != null) {
                fileStream.close();
            }
        } catch (IOException e) {
            // Log the error and handle it, e.g., by propagating it up the call stack
            throw new RuntimeException("Error closing file", e);
        }
    }

    public static void main(String[] args) {
    }
}