import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessExecutor_3 {
    public static void main(String[] args) {
        // Create a new process builder with the command (e.g., "ls")
        ProcessBuilder pb = new ProcessBuilder("ls");
        pb.redirectErrorStream(true); // merge stderr into stdout
        try {
            Process process = pb.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder outputStringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                // append the line to the output string builder
                outputStringBuilder.append(line).append("\n");
            }
            System.out.println("Output: " + outputStringBuilder);
        } catch (Exception e) {
            // handle exception that occurs during process execution, etc.
            e.printStackTrace();
        }
    }
}