import java.util.concurrent.TimeUnit;

public class ProcessTimeoutExample {
    public static void main(String[] args) throws Exception {
        String command = "your-command-here";
        Process process = Runtime.getRuntime().exec(command);

        // Set the timeout duration
        boolean completed = process.waitFor(10, TimeUnit.SECONDS); // Timeout after 10 seconds

        if (!completed) {
            process.destroy(); // Destroy the process if it did not complete in time
            System.out.println("Process was terminated due to timeout");
        } else {
            int returnCode = process.exitValue();
            System.out.println("Process completed with exit code: " + returnCode);
        }
    }
}