import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListLocalUsers {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("net", "user");
        
        try {
            // Start the command
            Process process = processBuilder.start();
            
            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Wait for the process to end and check its exit code
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}