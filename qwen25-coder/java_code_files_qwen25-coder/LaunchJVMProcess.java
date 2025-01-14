import java.io.File;
import java.io.IOException;

public class LaunchJVMProcess {
    public static void main(String[] args) {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + "/bin/java";
        ProcessBuilder pb = new ProcessBuilder(javaBin, "-jar", "your-server.jar");

        File stdOutLog = new File("stdout.log");
        File stdErrLog = new File("stderr.log");

        try {
            pb.redirectOutput(stdOutLog);
            pb.redirectError(stdErrLog);

            Process p = pb.start();

            // Optionally wait for the process to complete
            int exitCode = p.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error launching or waiting for process: " + e.getMessage());
        }
    }
}