import java.lang.String;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileRenamer {
    public static void main(String[] args) {
        // Path to the new JAR file that you want to rename
        Path sourcePath = FileSystems.getDefault().getPath("/path/to/newfile.jar");
        
        // Path where the old JAR file is located (the one you want to replace)
        Path targetPath = FileSystems.getDefault().getPath("/path/to/originalfile.jar");

        try {
            // Move the new file to the old file's path, replacing the original
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File renamed and replaced successfully.");
        } catch (IOException e) {
            System.err.println("Failed to rename and replace the file: " + e.getMessage());
        }
    }
}