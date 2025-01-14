import java.lang.String;
import java.io.IOException;

public class SpawnProcess {
    public static void main(String[] args) {
        try {
            // Command to execute your updater script, wrapped with nohup to ignore SIGHUP and &
            String command = "nohup /path/to/your/updater.sh &";
            
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", command);
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}