import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;

public class ProcessKiller {

    public static boolean isProcessRunning(String processName) {
        try {
            Process process = Runtime.getRuntime().exec("tasklist.exe");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(processName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            // Handle exception
        }
        return false;
    }

    public static void killProcess(String processName) {
        try {
            Process process = Runtime.getRuntime().exec("taskkill /im " + processName);
            process.waitFor();
        } catch (Exception e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
        String processName = "chrome.exe";
        if (isProcessRunning(processName)) {
            System.out.println("Process is running. Killing it...");
            killProcess(processName);
        } else {
            System.out.println("Process is not running.");
        }
    }
}