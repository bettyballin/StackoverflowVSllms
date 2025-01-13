import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_611 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] command = {"ssh", "-t", "user@host", "cd /path/to/somewhere; exec $SHELL -l"};
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close(); // Close the reader to prevent resource leak
        process.waitFor();
    }
}