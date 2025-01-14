import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

public class LastAccessTimeExample {
    public static void main(String[] args) {
        Path path = Paths.get("path/to/your/file.txt");
        
        try {
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime lastAccessTime = attrs.lastAccessTime();
            System.out.println("Last access time: " + lastAccessTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}