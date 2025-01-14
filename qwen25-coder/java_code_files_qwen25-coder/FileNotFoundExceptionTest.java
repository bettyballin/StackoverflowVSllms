import java.util.Set;
import java.util.HashSet;
import org.junit.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;

public class FileNotFoundExceptionTest {

    @Test(expected = IOException.class)
    public void testFileNotFoundException() throws IOException {
        // Create a temporary directory
        Path tempDir = Files.createTempDirectory("test");
        
        try {
            // Set the permissions to read-only, effectively making it unwritable
            Set<PosixFilePermission> perms = new HashSet<>();
            Files.setPosixFilePermissions(tempDir, perms);
            
            // Attempt to create a file in the unwritable directory
            new FileOutputStream(tempDir.resolve("cache").toString()).close();
        } finally {
            // Clean up the temporary directory
            Files.deleteIfExists(tempDir.resolve("cache"));
            Files.deleteIfExists(tempDir);
        }
    }

    public static void main(String[] args) {
    }
}