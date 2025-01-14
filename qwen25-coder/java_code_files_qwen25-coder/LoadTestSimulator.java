import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadTestSimulator {
    // Example: Simulating load test by running multiple threads
    private static final int EXPECTED_USER_LOAD = 100;

    static {
        ExecutorService executor = Executors.newFixedThreadPool(EXPECTED_USER_LOAD);
        for (int i = 0; i < EXPECTED_USER_LOAD; i++) {
            executor.submit(() -> performRequest());
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
    }

    private static void performRequest() {
        // Simulate performing a request
    }
}