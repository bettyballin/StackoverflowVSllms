import java.lang.String;
import java.io.IOException;

public class MapNetworkDrive {
    public static void main(String[] args) throws IOException {
        String driveLetter = "F";
        String uncPath = "\\\\server\\share";

        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "net use " + driveLetter + ": " + uncPath);
        pb.start();
    }
}