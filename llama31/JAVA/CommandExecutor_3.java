import java.io.File;
import java.io.IOException;

public class CommandExecutor_3_3 {
    public static void main(String[] args) throws IOException {
        // Specify the directory where the command should be executed
        File cmdDir = new File("path_to_directory");

        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "x");
        pb.directory(cmdDir);
        pb.redirectErrorStream(true);
        Process p = pb.start();

        // Write to the input stream to simulate user input
        p.getOutputStream().write("y\n".getBytes()); // 'y' is just an example, replace with the desired input
        p.getOutputStream().flush();
    }
}