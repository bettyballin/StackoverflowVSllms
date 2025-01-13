import java.lang.String;
import java.util.concurrent.TimeUnit;

public class ProcessExecutor {
    public static void main(String[] args) throws Exception {
        String command = "your_command_here"; // replace with your command
        Process process = Runtime.getRuntime().exec(command);

        // Wait for the process to finish or timeout after 10 seconds
        if (!process.waitFor(10, TimeUnit.SECONDS)) {
            // If the process did not finish within the timeout period, terminate it
            process.destroyForcibly();
        }
    }
}