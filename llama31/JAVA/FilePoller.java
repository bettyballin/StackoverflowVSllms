import java.lang.String;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FilePoller {
    public static void main(String[] args) throws IOException {
        String filePath = "/path/to/your/file.csv";
        long lastPosition = 0;

        while (true) {
            try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
                long currentPosition = file.length();
                if (currentPosition > lastPosition) {
                    file.seek(lastPosition);
                    // Read the new line from the file
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = file.read(buffer)) != -1) {
                        // Process the new line
                    }
                    lastPosition = currentPosition;
                }
            }

            try {
                Thread.sleep(1000); // Poll every 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}