import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessExecutor_1 {
    public static void execute(String... command) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(command);
        final Process p = pb.start();
        // Consume stdout
        Thread t1 = new Thread(() -> consumeOutputStream("stdout", p.getInputStream()));
        t1.setDaemon(true);
        t1.start();

        // Consume stderr and write to stdout (this is optional)
        Thread t2 = new Thread(() -> consumeOutputStream("stderr", p.getErrorStream()));
        t2.setDaemon(true);
        t2.start();

        try {
            int exitValue = p.waitFor();
            System.out.println("Process exited with code " + exitValue);
        } catch (InterruptedException e) {
            // Handle the exception as needed
            Thread.currentThread().interrupt();
        }
    }

    private static void consumeOutputStream(String prefix, InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(prefix + ": " + line);
            }
        } catch (IOException e) {
            // Handle exception as needed
        }
    }

    public static void main(String[] args) {
    }
}