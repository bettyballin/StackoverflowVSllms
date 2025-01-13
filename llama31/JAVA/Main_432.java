import java.io.IOException;

public class Main_432 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("path/to/your/exe", "arg1", "arg2");
            Process p = pb.start();
        } catch (IOException e) {
            System.err.println("Error starting process: " + e.getMessage());
        }
    }
}