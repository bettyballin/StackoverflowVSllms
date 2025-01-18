import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder("yourExecutableName").start(); // Update with real executable name instead of 'yourExecutableName'
            int exitVal = process.waitFor();  // Wait for the termination of this process
            if (exitVal == 0) {   // If program executed successfully without exception
                System.out.println("Application ran successfully");
            } else {
                // The application did not run successfully, handle and log error message accordingly
            }
        } catch (InterruptedException | IOException e) {
            // Exception occurred when executing the process or wait condition met some problem (e.g., timeout)
            // Handle exception here with try/catch block and logging if necessary.
        }
    }
}