// Example of how Apache Commons Exec library can be used:

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
// Removed the import of org.apache.commons.exec.Executor to avoid conflict
import org.apache.commons.exec.ExecuteException;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // Create new thread pool of 2 threads for concurrent execution.

        executorService.submit(() -> {
            CommandLine cmd1 = new CommandLine("/path/to/jarfile");
            org.apache.commons.exec.Executor executor1 = new DefaultExecutor();
            try {
                executor1.execute(cmd1); // Execute the first run in background
            } catch (ExecuteException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // ... repeat above lines to execute second run
        executorService.submit(() -> {
            CommandLine cmd2 = new CommandLine("/path/to/jarfile");
            org.apache.commons.exec.Executor executor2 = new DefaultExecutor();
            try {
                executor2.execute(cmd2); // Execute the second run in background
            } catch (ExecuteException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown(); // Don't forget to shutdown the executor service.
    }
}