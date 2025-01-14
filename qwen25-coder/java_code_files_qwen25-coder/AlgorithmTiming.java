import java.lang.String;
public class AlgorithmTiming {
    public static void main(String[] args) {
        // Warm-up the JVM (1000 runs)
        for (int i = 0; i < 1000; i++) {
            algorithmToTest();
        }

        long startTime, endTime, duration;
        int numberOfRuns = 5;

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfRuns; i++) {
            algorithmToTest();
        }
        endTime = System.nanoTime();

        duration = (endTime - startTime) / numberOfRuns;
        System.out.println("Average runtime: " + duration + " nanoseconds per run");
    }

    // Example sorting/searching method to test
    private static void algorithmToTest() {
        int[] array = {5, 2, 8, 3, 1};
        java.util.Arrays.sort(array);
    }
}