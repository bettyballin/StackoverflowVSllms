import java.nio.file.*;
import java.nio.file.InvalidPathException;

public class Main {
    public static void main(String[] args) {
        try {
            Path p = Paths.get("").resolveSibling(".profile");
            if (Files.exists(p)) {
                System.out.println("Unix based OS found.");
            } else {
                // If no .profile file is found, it's likely a Windows system or other unsupported OS.
                System.out.println("Other OS.");
            }
        } catch (InvalidPathException e) {
            // Handle exception: usually should never come here
        }
    }
}