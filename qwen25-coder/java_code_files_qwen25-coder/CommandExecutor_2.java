import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor_2 {

    public void executeCommand(String command) {
        try {
            // Initialize ProcessBuilder with the given command
            ProcessBuilder pb = new ProcessBuilder(command.split(" "));

            // Start the process
            Process process = pb.start();

            // Get stream to read output of executed command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Read the output of the command and print it
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Also handle error stream
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println("ERROR: " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CommandExecutor_2 executor = new CommandExecutor_2();
        if (args.length > 0) {
            executor.executeCommand(String.join(" ", args));
        } else {
            System.out.println("Please provide a command to execute.");
        }
    }
}