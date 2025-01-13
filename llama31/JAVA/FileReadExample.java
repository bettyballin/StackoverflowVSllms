import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileReadExample {
    public static void main(String[] args) throws IOException {
        // Create an executor service with 4 threads (adjust according to your system)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // List of files to read
        File[] files = new File("/path/to/files").listFiles();

        // Read files in parallel using executor service
        executor.invokeAll(Arrays.asList(files).stream().map(file -> (Callable<String>) () -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString();
            } catch (IOException e) {
                // Handle exceptions
                return null;
            }
        }));

        // Shut down the executor service
        executor.shutdown();
    }
}