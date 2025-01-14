import java.lang.String;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Tailer {
    private static final int SLEEP_MILLIS = 100; // sleep interval in milliseconds

    public static void main(String[] args) throws IOException {
        File fileToWatch = new File("path/to/your/file.txt");
        if (!fileToWatch.exists()) {
            System.out.println("File does not exist: " + fileToWatch.getAbsolutePath());
            return;
        }

        long lastKnownPosition = 0;

        // Open the file with read only access
        try (RandomAccessFile reader = new RandomAccessFile(fileToWatch, "r")) {
            while (true) {
                // Move to last known position in file.
                if (lastKnownPosition > fileToWatch.length()) {
                    reader.seek(0);
                    lastKnownPosition = 0; // start from the beginning
                } else {
                    reader.seek(lastKnownPosition);
                }

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Read: " + line); // Replace with your check logic
                    lastKnownPosition = reader.getFilePointer();
                }
                
                // Sleep for a while before next read attempt
                Thread.sleep(SLEEP_MILLIS);
            }
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted!");
        }
    }
}