import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempDirExample {
    public static void main(String[] args) throws IOException {
        Path tempDir = Files.createTempDirectory("myTempDir");
        System.out.println(tempDir);
        // Clean up when done
        tempDir.toFile().deleteOnExit();
    }
}