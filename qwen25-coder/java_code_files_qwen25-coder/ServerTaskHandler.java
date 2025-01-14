import java.lang.String;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTaskHandler {
    public static void main(String[] args) {
        // Create an ExecutorService that uses all available processors
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfProcessors);
        
        // Submit tasks to the executor service
        for (int i = 0; i < 350; i++) {
            executor.submit(() -> {
                handleUserRequest(); // Simulate handling a user request
            });
        }
        executor.shutdown();
    }

    private static void handleUserRequest() {
        try {
            // Simulate processing time for each request
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}