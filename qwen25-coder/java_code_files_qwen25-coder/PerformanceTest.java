import java.lang.String;
public class PerformanceTest {
    public static void main(String[] args) {
        // Start time
        long startTime = System.nanoTime();

        // Function to be tested
        yourFunction();

        // End time
        long endTime = System.nanoTime();

        // Calculate duration in milliseconds
        double durationInMillis = (endTime - startTime) / 1_000_000.0;

        // Output the result
        System.out.println("Execution time: " + durationInMillis + " ms");
    }

    private static void yourFunction() {
        // Replace with your function logic
        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
    }
}