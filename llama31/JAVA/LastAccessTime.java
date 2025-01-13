import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class LastAccessTime {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt"; // replace with your file path
        Path path = Paths.get(filePath);

        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            long lastAccessTime = attributes.lastAccessTime().toMillis();
            System.out.println("Last access time: " + lastAccessTime);
        } catch (IOException e) {
            System.err.println("Error reading file attributes: " + e.getMessage());
        }
    }
}