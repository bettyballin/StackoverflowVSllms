import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Wrapper_1_1 {
    public static void main(String[] args) {
        // Create an executor service with a pool of threads equal to the number of available cores
        int numCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numCores);

        // Read one line from a file and submit a task to the executor for each line
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Submit a task to the executor that calls the "former" main method
                executor.submit(() -> FormerMain.main(line));
            }
        } catch (IOException e) {
            // Handle exception
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Shut down the executor service
        executor.shutdown();
    }
}

class FormerMain {
    public static void main(String line) {
        // Your former main method implementation here
        System.out.println(line);
    }
}