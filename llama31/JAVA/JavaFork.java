import java.lang.String;
import java.io.IOException;

public class JavaFork {
    public static void main(String[] args) throws IOException {
        // Create a new process builder
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "IndependentProcess");

        // Start the new process
        Process process = pb.start();
    }
}

class IndependentProcess {
    public static void main(String[] args) {
        // This will run in a new, independent JVM process
        System.out.println("Hello from independent process!");
    }
}