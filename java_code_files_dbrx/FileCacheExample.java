import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class FileCacheExample {
    private ExecutorService executor = Executors.newFixedThreadPool(10); // Create a fixed thread pool with 10 threads
    private Map<Path, String> fileContents = new ConcurrentHashMap<>(); // ConcurrentHashMap for storing the contents of files in memory

    public void loadFilesIntoMemory() throws IOException {
        Files.list(Paths.get("path/to/directory")) // List all files in the directory
            .filter(p -> !Files.isDirectory(p)) // Ignore directories
            .forEach(filePath -> executor.submit(() -> readFileIntoMemory(filePath))); // Submit a task to read each file asynchronously and store its content into ConcurrentHashMap<Path,String> map
        executor.shutdown(); // Initiates an orderly shutdown
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS); // Wait for all tasks to complete (optional)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void readFileIntoMemory(Path path) {
        try {
            String content = new String(Files.readAllBytes(path)); // Read the entire file into memory as a single string
            fileContents.put(path, content); // Store the file's contents in the ConcurrentHashMap (used to manipulate them)

            // Manipulate the contents here, e.g., replace specific words or phrases:
            String contentToSaveBack = fileContents.get(path).replace("old", "new");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

	public static void main(String[] args) {
        FileCacheExample example = new FileCacheExample();
        try {
            example.loadFilesIntoMemory();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}