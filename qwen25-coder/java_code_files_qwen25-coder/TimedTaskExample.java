import java.lang.String;
import java.util.concurrent.*;

public class TimedTaskExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        Future<String> future = executor.submit(() -> {
            // Simulate a long-running task with Thread.sleep()
            Thread.sleep(15000); // Sleeps for 15 seconds to simulate a long computation
            return "Result of the analysis";
        });

        try {
            String result = future.get(10, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Time out! Analysis took longer than 10 seconds.");
            future.cancel(true); // Attempt to stop the task
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow(); // Shut down the ExecutorService
        }
    }
}