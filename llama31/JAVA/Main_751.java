import org.apache.commons.lang3.time.StopWatch;

public class Main_751 {
    public static void main(String[] args) {
        // Create a new StopWatch instance
        StopWatch stopWatch = new StopWatch();

        try {
            // Start the stopwatch
            stopWatch.start();
            
            // Your function call or code block to be timed goes here
            // For demonstration, we'll just wait for 2 seconds
            Thread.sleep(2000);
            
        } catch (InterruptedException e) {
            // Handle the exception if the thread is interrupted
            System.err.println("Thread was interrupted");
            Thread.currentThread().interrupt(); // Restore interrupted status
        } finally {
            // Stop the stopwatch
            stopWatch.stop();
        }
        
        // Print the execution time
        System.out.println("Execution time: " + stopWatch.getTime() + " milliseconds");
    }
}