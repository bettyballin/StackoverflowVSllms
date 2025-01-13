import java.io.IOException;

public class Main_585 {
    public static void main(String[] args) {
        String[] command = {"jdeprscan", "-classpath", "/path/to/your/application.jar", "-verbose"};
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error running jdeprscan: " + e.getMessage());
        }
    }
}