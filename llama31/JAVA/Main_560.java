import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_560_560 {
    public static void main(String[] args) {
        Path filePath = Paths.get("/path/to/your/file");
        try {
            if (Files.isSymbolicLink(filePath)) {
                System.out.println("The file is a symbolic link.");
            } else {
                System.out.println("The file is not a symbolic link.");
            }
        } catch (IOException e) {
            System.err.println("Error checking file: " + e.getMessage());
        }
    }
}