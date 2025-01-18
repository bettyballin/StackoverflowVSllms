import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamExample {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/path/to/your/file"))) {
            // Use the buffered input stream for your operations here.
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
}