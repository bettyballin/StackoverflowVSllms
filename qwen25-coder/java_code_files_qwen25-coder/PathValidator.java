import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathValidator {
    public static boolean isValidPath(String path) {
        try {
            // Attempt to create a Path object from the string
            Path p = Paths.get(path);
            
            // Check if the path is absolute, you can modify this logic based on your requirements
            return true; // If no exception is thrown, consider it a valid path
        } catch (Exception e) {
            // An invalid path will throw an IllegalArgumentException or InvalidPathException
            return false;
        }
    }

    public static void main(String[] args) {
        String[] paths = { "C:/foo", "/foo", "banana" };
        
        for (String p : paths) {
            System.out.println("Is valid: " + isValidPath(p) + " for path: " + p);
        }
    }
}