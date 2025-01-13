import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class ProcessRunner {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), YourMainClass.class.getName());
        pb.redirectErrorStream(true);
        Process p = pb.start();

        // Read from the process's output stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Write to the process's input stream
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        writer.write("Hello, subprocess!");
        writer.newLine();
        writer.flush();
    }
}