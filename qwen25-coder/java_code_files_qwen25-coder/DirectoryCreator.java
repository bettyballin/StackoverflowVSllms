import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryCreator {
    public static void main(String[] args) {
        String baseDir = "C:\\";
        String a = "folder1";
        String b = "folder2";
        String c = "file";

        // Build the path
        Path path = Paths.get(baseDir, a, b);
        
        try {
            // Create directories if they don't exist
            Files.createDirectories(path);

            // Create and write to the file
            Path filePath = Paths.get(path.toString(), c + ".txt");
            Files.write(filePath, "Hello, world!".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}