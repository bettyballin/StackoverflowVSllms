import java.lang.String;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SafeFileUpdater {

    public static void updateFile(Path targetFile, byte[] newData) throws IOException {
        // Create a temporary file in the same directory as the target file
        Path tempFile = Files.createTempFile(targetFile.toAbsolutePath().getParent(), "temp", null);
        
        try (OutputStream os = Files.newOutputStream(tempFile)) {
            // Write newData to the temporary file
            os.write(newData);
        }

        // Replace the old file with the new one atomically
        Files.move(tempFile, targetFile, StandardCopyOption.ATOMIC_MOVE);
    }

    public static void main(String[] args) {
    }
}