import java.lang.String;
public class MicroBenchmark {

    private static final int WARM_UP_ITERATIONS = 1000;
    private static final int MEASUREMENT_ITERATIONS = 10000;

    public static void main(String[] args) {
        // Warm-up
        for (int i = 0; i < WARM_UP_ITERATIONS; i++) {
            performOperation();
        }

        // Measurement
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASUREMENT_ITERATIONS; i++) {
            performOperation();
        }
        long endTime = System.nanoTime();

        // Calculate iterations per second
        long elapsedTime = endTime - startTime;
        double iterationsPerSecond = (double) MEASUREMENT_ITERATIONS / (elapsedTime / 1e9);

        System.out.println("Iterations per second: " + iterationsPerSecond);
    }

    // Replace with the operation you want to benchmark
    private static void performOperation() {
        // Example operation
        int result = 0;
        for (int i = 0; i < 100; i++) {
            result += i;
        }
    }
}