import java.nio.file.*;
import java.io.IOException;
import java.util.concurrent.*;

public class FileLoadingExample {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10); // Create a fixed thread pool with 10 threads

    public void loadFilesIntoMemory() throws InterruptedException, IOException {
        Files.list(Paths.get("path/to/directory")) // List all files in the directory
            .filter(p -> !Files.isDirectory(p)) // Ignore directories
            .forEach(filePath -> {
                executor.submit(() -> readFile(filePath)); // Submit a task to read each file asynchronously
            });
        executor.shutdown(); // Initiates an orderly shutdown
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS); // Wait for all tasks to complete (optional)
    }

    private void readFile(Path path) {
        try {
            String content = new String(Files.readAllBytes(path)); // Read the entire file into memory as a single string

            // Manipulate the contents here, e.g., replace specific words or phrases:
            content = content.replace("old", "new");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
    }
}