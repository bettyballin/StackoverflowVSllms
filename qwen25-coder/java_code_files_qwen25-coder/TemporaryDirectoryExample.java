import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemporaryDirectoryExample {
    public static void main(String[] args) {
        try {
            // Create a temporary directory
            Path tempDir = Files.createTempDirectory("myTemporaryDirPrefix");
            System.out.println("Temporary directory created at: " + tempDir);

            // You can now use the tempDir as needed

            // Optionally, delete the directory when done (ensure all files are deleted first)
            // Files.delete(tempDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}