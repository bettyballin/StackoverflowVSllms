import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExecutor_1 {
    public static String executeCommand(String command) throws Exception {
        StringBuilder result = new StringBuilder();
        Process process = Runtime.getRuntime().exec(command);
        
        // Capture the output stream of the command
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append(System.lineSeparator());
            }
        }

        // Wait for the process to complete and check exit value
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Command failed with exit code " + exitCode);
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        try {
            String output = executeCommand("ping -c 4 google.com");
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}