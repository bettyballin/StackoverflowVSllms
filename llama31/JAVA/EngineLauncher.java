import java.lang.String;
import java.io.IOException;

public class EngineLauncher {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("engine.exe");
        pb.environment().put("USERNAME", "your_username");
        pb.environment().put("PASSWORD", "your_password");
        Process p = pb.start();
    }
}