import java.lang.String;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class FileHandler_1 {
    private static final int MAX_RETRIES = 5;
    private static final long RETRY_DELAY_MS = 200;

    public static void writeFileWithRetry(File file, byte[] content) throws IOException {
        int attempt = 0;
        while (attempt < MAX_RETRIES) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(content);
                return; // Success
            } catch (IOException e) {
                if (++attempt >= MAX_RETRIES) throw e; // Re-throw exception after max retries
                try { Thread.sleep(RETRY_DELAY_MS); } catch (InterruptedException ie) {}
            }
        }
    }

    public static byte[] readFileWithRetry(File file) throws IOException {
        int attempt = 0;
        while (attempt < MAX_RETRIES) {
            try {
                return Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                if (++attempt >= MAX_RETRIES) throw e; // Re-throw exception after max retries
                try { Thread.sleep(RETRY_DELAY_MS); } catch (InterruptedException ie) {}
            }
        }
        return null;
    }

	public static void main(String[] args) {
	}
}