import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class Main_182 {
    public static void main(String[] args) {
        Path path = Paths.get("path/to/your/file");
        long yourDesiredTimestamp = 1643723900000L; // replace with your desired timestamp in milliseconds
        FileTime timestamp = FileTime.fromMillis(yourDesiredTimestamp); // in UTC
        try {
            Files.setLastModifiedTime(path, timestamp);
        } catch (IOException e) {
            // handle exception
            System.err.println("Error setting last modified time: " + e.getMessage());
        }
    }
}