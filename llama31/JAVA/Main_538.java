import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main_538 {
    public static void main(String[] args) {
        // assume 'newFile' is the path to the new JAR file
        // and 'existingFile' is the path to the existing JAR file
        Path newFile = Paths.get("path/to/new/jar");
        Path existingFile = Paths.get("path/to/existing/jar");

        try {
            Files.move(newFile, existingFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // handle the exception
            System.err.println("Error moving file: " + e.getMessage());
        }
    }
}