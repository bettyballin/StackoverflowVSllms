import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main_245 {
    public static void main(String[] args) throws IOException {
        // String s comes from external source
        String s = "example"; // replace with your external source

        Path filePath = Paths.get(System.getProperty("user.home"), s);
        Path safeFilePath = Files.createTempFile(filePath.getParent(), filePath.getFileName().toString(), ".tmp");

        // Use safeFilePath to create your PrintWriter
        try (PrintWriter currentWriter = new PrintWriter(safeFilePath.toFile())) {
            // Use currentWriter
        }
    }
}