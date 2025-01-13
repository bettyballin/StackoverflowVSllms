import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main_246 {
    public static void main(String[] args) {
        String s = "example/file.txt"; // comes from external source
        FileSystem fs = FileSystems.getDefault();
        Path filePath = fs.getPath(System.getProperty("user.home"), s);
        Path safeFilePath = fs.getPath(System.getProperty("user.home"), fs.getPath(s).getFileName().toString().replace('/', '_'));

        // Use safeFilePath to create your PrintWriter
        try (PrintWriter currentWriter = new PrintWriter(safeFilePath.toFile())) {
            // Use currentWriter to write to the file
            currentWriter.println("Hello, World!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}