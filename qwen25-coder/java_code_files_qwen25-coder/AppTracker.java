import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppTracker {
    public static void main(String[] args) throws Exception {
        while (true) {
            Process process = Runtime.getRuntime().exec("ps -e");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            System.out.println("Running processes:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            Thread.sleep(900000); // Sleep for 15 minutes
        }
    }
}