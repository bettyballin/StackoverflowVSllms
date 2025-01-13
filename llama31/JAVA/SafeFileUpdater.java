import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SafeFileUpdater {
    public void updateFile(String originalFilePath, byte[] newContent) throws IOException {
        Path originalFile = Paths.get(originalFilePath);
        Path tempFile = Files.createTempFile(originalFile.getParent(), "temp", ".tmp");

        try {
            Files.write(tempFile, newContent);
            Files.move(tempFile, originalFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // Handle write failure, temp file will be deleted on JVM exit
            Files.deleteIfExists(tempFile);
            throw e;
        }
    }

	public static void main(String[] args) {
	}
}