import java.io.*;
import java.util.concurrent.*;

public class CommandExecutor {
    private static final int TIMEOUT = 10; // Set desired timeout value in seconds

    public static void main(String[] args) throws Exception {
        boolean printOutput = true, printError = false;
        String commandLine = "your_command"; // Replace with your command
        executeCommandLine(commandLine, TIMEOUT, printOutput, printError);
    }

    public static int executeCommandLine(String commandLine, int timeout, boolean printOutput, boolean printError) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> callable = () -> {
            try {
                Runtime runtime = Runtime.getRuntime();
                Process process = runtime.exec(commandLine);

                if (printOutput) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    System.out.println("Output:\n" + reader.readLine());
                }

                if (printError) {
                    BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                    System.err.println("Error:\n" + errorReader.readLine());
                }

                return process.waitFor();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Future<Integer> future = executor.submit(callable);
        int exitCode;
        try {
            exitCode = future.get(timeout, TimeUnit.SECONDS); // Set timeout for command execution
            System.out.println("Exit value: " + exitCode);
        } catch (TimeoutException e) {
            future.cancel(true); // Interrupt the process if it times out
            throw new RuntimeException("Command timed out after " + timeout + " seconds.");
        } finally {
            executor.shutdownNow(); // Important to shut down the thread pool when finished
        }
        return exitCode;
    }
}