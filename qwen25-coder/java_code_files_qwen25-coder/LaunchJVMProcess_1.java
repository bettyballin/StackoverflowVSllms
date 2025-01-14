import java.lang.String;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LaunchJVMProcess_1 {
    public static void main(String[] args) {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + "/bin/java";
        try {
            Process p = Runtime.getRuntime().exec(javaBin + " -jar your-server.jar");

            // Redirect output and error to files
            streamGobbler(p.getInputStream(), new FileOutputStream("stdout.log"));
            streamGobbler(p.getErrorStream(), new FileOutputStream("stderr.log"));

            int exitCode = p.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error launching or waiting for process: " + e.getMessage());
        }
    }

    private static void streamGobbler(InputStream is, FileOutputStream os) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            os.write(line.getBytes());
            os.write(System.lineSeparator().getBytes());
        }
        reader.close();
        os.close();
    }
}