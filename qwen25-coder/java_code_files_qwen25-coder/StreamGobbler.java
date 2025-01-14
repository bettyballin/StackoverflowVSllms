import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamGobbler extends Thread {
    private InputStream inputStream;

    public StreamGobbler(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line read from the stream
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("your-command", "arg1", "arg2");
        Process process = processBuilder.start();

        // Gobble the inputStream and errorStream in separate threads
        Thread outputGobbler = new StreamGobbler(process.getInputStream());
        Thread errorGobbler = new StreamGobbler(process.getErrorStream());

        outputGobbler.start();
        errorGobbler.start();

        // Wait for the command to finish execution
        int exitCode = process.waitFor();
        System.out.println("Process exited with code: " + exitCode);
    }
}