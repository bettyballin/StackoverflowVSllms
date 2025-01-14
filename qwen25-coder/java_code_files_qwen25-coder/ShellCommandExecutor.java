import java.lang.String;
import java.io.IOException;

public class ShellCommandExecutor {
    try {
        // Example: execute a simple shell command
        Process process = Runtime.getRuntime().exec("echo Hello, World");
        
        // Optionally handle input/output streams and errors here
    } catch (IOException e) {
        e.printStackTrace();
    }

    public static void main(String[] args) {
    }
}