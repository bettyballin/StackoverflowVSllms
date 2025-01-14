import java.lang.String;
public class PerformanceProfiler {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        // Function to profile
        performTask();
        
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    private static void performTask() {
        // Simulate some task that needs profiling
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
    }
}