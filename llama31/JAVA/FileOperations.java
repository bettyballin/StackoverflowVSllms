import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileOperations {

    public static void main(String[] args) {
        // Define source and target paths
        Path source = Paths.get("/path/to/source/file.txt");
        Path target = Paths.get("/path/to/target/");

        // Copy file
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }

        // Move file
        try {
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully");
        } catch (IOException e) {
            System.err.println("Error moving file: " + e.getMessage());
        }
    }
}