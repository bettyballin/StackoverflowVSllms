import java.io.IOException;

public class VbProgramRunner {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("path/to/your/vb/program.exe");
            Process process = pb.start();
        } catch (IOException e) {
            System.err.println("Error executing VB program: " + e.getMessage());
        }
    }
}