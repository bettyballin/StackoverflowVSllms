import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SmartctlExample {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("smartctl -a /dev/sda");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Command executed successfully.");
            } else {
                System.err.println("Failed to execute command. Exit code: " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}