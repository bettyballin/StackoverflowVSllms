import java.lang.String;
import java.io.IOException;

public class ForkExample {
    public static void main(String[] args) {
        // Assuming the class you want to run is in the same package and classpath
        String className = "com.example.YourClassName";

        try {
            // Use ProcessBuilder to run the other class in a new JVM
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), className);
            
            // Redirect error stream to standard out for easier reading if needed
            processBuilder.redirectErrorStream(true);

            // Start process
            Process process = processBuilder.start();

            // Optionally, you can read the output of the forked process
            // try (InputStream in = process.getInputStream()) {
            //     int ch;
            //     while((ch = in.read()) != -1) {
            //         System.out.print((char)ch);
            //     }
            // }

            // Wait for the process to finish and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Process exited with code " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}