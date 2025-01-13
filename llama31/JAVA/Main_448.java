import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_448 {
    public static void main(String[] args) throws IOException {
        String processId = "your_process_id_here"; // replace with the actual process ID
        String command = "taskkill /PID " + processId + " /F";

        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}