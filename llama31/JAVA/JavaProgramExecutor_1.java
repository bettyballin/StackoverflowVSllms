import java.io.InputStream;
import java.io.IOException;

public class JavaProgramExecutor_1_1 {
    public static void main(String[] args) throws IOException {
        // Create a process builder
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "myprogram.jar");

        // Execute the Java program multiple times
        for (int i = 0; i < 5; i++) {
            Process process = pb.start();
            // Read the output from the process
            InputStream inputStream = process.getInputStream();
            // ... handle inputStream, for example:
            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}