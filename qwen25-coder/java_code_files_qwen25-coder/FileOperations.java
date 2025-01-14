import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileOperations {
    public static void main(String[] args) {
        // Define source and destination paths
        Path sourcePath = Paths.get("path/to/source/file.txt");
        Path destinationPath = Paths.get("path/to/destination/file.txt");

        try {
            // Copy the file to the new location
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");

            // Move (or rename) the file to a new location
            Files.move(sourcePath, destinationPath.resolve("newFileName.txt"), StandardCopyOption.ATOMIC_MOVE);
            System.out.println("File moved successfully.");
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}