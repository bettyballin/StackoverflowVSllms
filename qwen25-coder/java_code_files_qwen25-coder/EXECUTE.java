import java.lang.String;
import java.io.IOException;

public class EXECUTE {

    public static void application(String className) throws IOException {
        // Constructing the command to run the Java application.
        String[] command = {"java", "-cp", System.getProperty("java.class.path"), className};

        // Execute the command in a separate process.
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
    }

    public static void main(String[] args) {
        try {
            // Example usage
            EXECUTE.application("com.example.YourMainClass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}