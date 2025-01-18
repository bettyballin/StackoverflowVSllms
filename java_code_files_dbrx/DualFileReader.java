import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DualFileReader {
    public static void main(String[] args) {
        Path filePath = null;
        try (BufferedReader reader1 = Files.newBufferedReader(filePath);
             BufferedReader reader2 = Files.newBufferedReader(filePath)) {
            // Read with reader1...
            // Then read again from the top using reader2, if needed:
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}