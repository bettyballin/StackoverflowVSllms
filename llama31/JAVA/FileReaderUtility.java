import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderUtility {
    public static void main(String[] args) {
        Path filePath = Paths.get("yourfile.txt");
        try (BufferedReader bufferedReader1 = Files.newBufferedReader(filePath)) {
            // read the file with bufferedReader1
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        try (BufferedReader bufferedReader2 = Files.newBufferedReader(filePath)) {
            // read the file again with bufferedReader2
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}