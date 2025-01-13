import java.lang.String;
public class SynchronizationBenchmark {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        Object lock = new Object();

        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            synchronized (lock) {
                // do some work
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += j;
                }
            }
        }
        long endTime = System.nanoTime();

        System.out.println("Synchronized time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            // do some work without synchronization
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += j;
            }
        }
        endTime = System.nanoTime();

        System.out.println("Unsynchronized time: " + (endTime - startTime) + " ns");
    }
}