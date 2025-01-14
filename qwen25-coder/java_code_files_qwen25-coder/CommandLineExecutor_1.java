import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class CommandLineExecutor {

    public static int executeCommandLine(final String commandLine,
                                         final boolean printOutput,
                                         final boolean printError,
                                         final long timeoutInMillis)
            throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Specify the exact command and its arguments
        processBuilder.command(commandLine.split(" "));

        Process process = processBuilder.start();

        Thread outputThread = null;
        if (printOutput) {
            outputThread = new Thread(() -> {
                try (BufferedReader outputReader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = outputReader.readLine()) != null) {
                        System.out.println("Output: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            outputThread.start();
        }

        Thread errorThread = null;
        if (printError) {
            errorThread = new Thread(() -> {
                try (BufferedReader errorReader = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()))) {
                    String line;
                    while ((line = errorReader.readLine()) != null) {
                        System.out.println("Error: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            errorThread.start();
        }

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            return process.waitFor();
        });

        boolean isCompleted = false;
        try {
            future.get(timeoutInMillis, TimeUnit.MILLISECONDS);
            isCompleted = true;
        } catch (TimeoutException e) {
            // Timeout has occurred
            isCompleted = false;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }

        // Destroy the process if it did not finish within the timeout
        if (!isCompleted) {
            process.destroy();
            return -1; // or some specific error code for timeout
        }

        // Ensure that threads finish processing remaining output/error data if any
        if (outputThread != null) outputThread.join();
        if (errorThread != null) errorThread.join();

        return process.exitValue();
    }

    // Optional main method for testing
    public static void main(String[] args) {
        try {
            int exitCode = executeCommandLine("echo Hello, World!", true, true, 5000);
            System.out.println("Process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}