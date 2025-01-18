import java.util.concurrent.*;
import java.io.IOException;

public class ProcessTimeoutExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // The process variable needs to be accessible in the catch block
        final Process[] processHolder = new Process[1];
        String command = "your-command-here"; // define the command
        long timeout = 60; // define timeout in seconds

        Callable<Integer> callable = () -> {
            try {
                Process process = Runtime.getRuntime().exec(command);
                processHolder[0] = process;
                return process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        };

        Future<Integer> future = executor.submit(callable);

        try {
            int returnCode = future.get(timeout, TimeUnit.SECONDS); // wait for timeout seconds
        } catch (TimeoutException e) {
            // Terminate the process if it didn't complete in the given time limit
            if (processHolder[0] != null) {
                processHolder[0].destroy();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow(); // shutdown ExecutorService to release resources
        }
    }
}