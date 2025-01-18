import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GetProcessIdByName {
    public static void main(String[] args) {
        String exeName = "your_exe_name"; // Replace this with your desired executable name
        int pid = -1;
        try {
            Process processList = new ProcessBuilder("cmd", "/c", "tasklist").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(processList.getInputStream()));
            String line;            
            while ((line = reader.readLine()) != null) {
                if (line.contains(exeName)) {
                    // Extract the PID from the tasklist command output
                    Pattern p = Pattern.compile("(\\d+)");
                    Matcher m = p.matcher(line);
                    while (m.find()) {
                        pid = Integer.parseInt(m.group());
                    }
                }
            }
            // Use the pid as needed
            System.out.println("PID of " + exeName + ": " + pid);
        } catch (IOException e) {
            // Handle the exception according to your use case
            throw new RuntimeException("Failed to get process list", e);
        }
    }
}