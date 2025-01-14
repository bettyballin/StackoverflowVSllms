import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SymbolicLinkCheck {
    public static void main(String[] args) {
        Path path = Paths.get("/path/to/your/file");
        
        try {
            boolean isSymbolicLink = Files.isSymbolicLink(path);
            if (isSymbolicLink) {
                System.out.println("The file is a symbolic link.");
            } else {
                System.out.println("The file is not a symbolic link.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}