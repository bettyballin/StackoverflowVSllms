import java.lang.String;
public class CodeProfiler {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Start time before the code path

        // Example code path to profile
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }

        long endTime = System.nanoTime(); // End time after the code path
        long duration = (endTime - startTime);  // Total execution time in nanoseconds

        System.out.println("Execution time: " + duration + " ns");
    }
}