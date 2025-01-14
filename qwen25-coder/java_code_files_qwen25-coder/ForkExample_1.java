import java.lang.String;
import java.io.IOException;

public class ForkExample_1 {
    public static void main(String[] args) {
        // Create a ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "path/to/your/classes", "YourMainClass");

        try {
            // Start the process
            Process process = pb.start();
            
            // Optionally, you can wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}