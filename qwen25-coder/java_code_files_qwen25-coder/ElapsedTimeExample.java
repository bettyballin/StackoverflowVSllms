import java.lang.String;
public class ElapsedTimeExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Perform the event or task
        performTask();

        long endTime = System.currentTimeMillis();
        long elapsedTimeMillis = endTime - startTime;

        System.out.println("Elapsed time in milliseconds: " + elapsedTimeMillis);
    }

    private static void performTask() {
        try {
            Thread.sleep(1000); // Simulate a 1-second task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}