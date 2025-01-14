import java.lang.String;
import java.io.IOException;

public class BinaryExecutor {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Command to execute a binary
        processBuilder.command("path-to-binary/binary-executable");

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.println("Exited with error code : " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}