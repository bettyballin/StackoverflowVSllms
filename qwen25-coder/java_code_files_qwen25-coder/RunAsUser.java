import java.io.IOException;

public class RunAsUser {
    public static void main(String[] args) throws IOException, InterruptedException {
        String username = "otherUser";
        String programPath = "\"C:\\Program Files\\SomeApp\\app.exe\"";

        // Construct the command to run as another user. Note: Password should NEVER be stored or passed directly.
        // Use the "/user" parameter and let Windows prompt for password securely.
        ProcessBuilder processBuilder = new ProcessBuilder("runas", "/user:" + username, programPath);
        
        // Set environment variables if necessary, but avoid setting passwords here.

        // Start the process
        Process process = processBuilder.start();

        // If you want to wait for it to finish, uncomment the next line.
        // int exitCode = process.waitFor();
        // System.out.println("Exited with code: " + exitCode);
    }
}