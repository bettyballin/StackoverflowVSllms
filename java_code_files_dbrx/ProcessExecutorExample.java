import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.exec.*;

public class ProcessExecutorExample {
    public static void main(String[] args) throws IOException {
        CommandLine cmdLine = new CommandLine("ls"); // Command to be executed is 'ls' (works on Unix systems)
        cmdLine.addArgument("-l");  // Adding arguments

        Executor executor = new DefaultExecutor(); // Using default implementation
        OutputStream outputStream = new ByteArrayOutputStream(); // Stream for capturing the process output

        ExecuteWatchdog watchDog = new ExecuteWatchdog(60 * 1000); // Set a timeout of 60 seconds
        executor.setWatchdog(watchDog); // Applying the watchdog to the executor

        executor.setStreamHandler(new PumpStreamHandler(outputStream)); // Redirect streams using PumpStreamHandler

        try {
            int exitValue = executor.execute(cmdLine); // Execute command and wait for process to complete
            System.out.print("Exit value: " + exitValue);

            String outputString = outputStream.toString();

            if (!outputString.equals("")) {
                System.out.println(outputString); // Print command execution output
            }
        } catch (ExecuteException e1) {
           // Error handling here...
           e1.printStackTrace();
        }
    }
}