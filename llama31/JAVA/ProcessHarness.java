import java.lang.String;
import java.io.*;

public class ProcessHarness {

    public static void main(String[] args) throws Exception {
        // Example of running a process and controlling its I/O
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), MyRunnable.class.getName());
        pb.redirectErrorStream(true); // Merge error stream into output stream

        // Setup input and output streams
        Process p = pb.start();
        OutputStream processInput = p.getOutputStream();
        InputStream processOutput = p.getInputStream();

        // Example of sending input
        String input = "Hello, other process!";
        processInput.write(input.getBytes());
        processInput.write(System.lineSeparator().getBytes()); // Send a newline to simulate pressing Enter
        processInput.flush();

        // Read output (simplified, doesn't handle all cases)
        BufferedReader reader = new BufferedReader(new InputStreamReader(processOutput));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Received from process: " + line);
        }

        p.waitFor(); // Wait for the process to finish
    }
}

class MyRunnable {
    public static void main(String[] args) throws Exception {
        // Simulate doing something with stdin/stdout
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Processed: " + line);
        }
    }
}