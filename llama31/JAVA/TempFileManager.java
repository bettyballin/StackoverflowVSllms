import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TempFileManager {
    public static void main(String[] args) {
        Path tmpFile = Paths.get("path_to_your_temp_file"); // replace with your temp file path
        try {
            Files.delete(tmpFile);
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
}