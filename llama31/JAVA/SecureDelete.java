import java.lang.String;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SecureDelete {
    public static void secureDelete(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.deleteIfExists(path);
        
        // If the file still exists, try to delete it using the File class
        File file = path.toFile();
        if (file.exists()) {
            file.delete();
        }
    }

    public static void main(String[] args) throws IOException {
        secureDelete("path/to/your/file.txt");
    }
}