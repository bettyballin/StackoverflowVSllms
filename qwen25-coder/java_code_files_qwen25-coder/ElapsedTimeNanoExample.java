import java.lang.String;
public class ElapsedTimeNanoExample {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Perform the event or task
        performTask();

        long endTime = System.nanoTime();
        long elapsedTimeNanos = endTime - startTime;

        System.out.println("Elapsed time in nanoseconds: " + elapsedTimeNanos);
    }

    private static void performTask() {
        try {
            Thread.sleep(1000); // Simulate a 1-second task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}