import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        // ... other code here...
        Path sourcePath = Paths.get("source.txt");
        Path targetPath = Paths.get("target.txt");
        try {
            Files.copy(sourcePath, targetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}