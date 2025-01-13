import java.io.IOException;
import java.lang.String;

public class ProcessRunner_2_2 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("your_command");
        pb.redirectErrorStream(true);
        Process p = pb.start();

        // Copy stdin to the process's stdin
        Thread stdinThread = new Thread(new Runnable() {
            public void run() {
                try {
                    int c;
                    while ((c = System.in.read()) != -1) {
                        p.getOutputStream().write(c);
                    }
                } catch (IOException e) {
                    // Handle exception
                    System.err.println("Error reading from stdin: " + e.getMessage());
                }
            }
        });
        stdinThread.start();

        // Copy the process's stdout to our stdout
        Thread stdoutThread = new Thread(new Runnable() {
            public void run() {
                try {
                    int c;
                    while ((c = p.getInputStream().read()) != -1) {
                        System.out.write(c);
                    }
                } catch (IOException e) {
                    // Handle exception
                    System.err.println("Error reading from process stdout: " + e.getMessage());
                }
            }
        });
        stdoutThread.start();

        // Wait for the process to finish
        p.waitFor();
    }
}