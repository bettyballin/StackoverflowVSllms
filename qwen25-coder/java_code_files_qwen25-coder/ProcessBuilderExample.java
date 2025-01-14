import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderExample {
    public static void main(String[] args) {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "dir");
        builder.redirectErrorStream(true);

        try {
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error occurred while executing command.");
        }
    }
}