import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ProcessExecutor_1_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("your_command_here"); // Replace "your_command_here" with the actual command you want to execute
        Process p = pb.start();
        InputStream stdout = p.getInputStream();
        InputStream stderr = p.getErrorStream();

        // Read from stdout and stderr
        BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
        BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));
        String line;
        while ((line = stdoutReader.readLine()) != null) {
            System.out.println(line);
        }
        while ((line = stderrReader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = p.waitFor();
        if (exitCode != 0) {
            // Handle error
            System.out.println("Error: Exit code " + exitCode);
        }
    }
}