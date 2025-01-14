import java.lang.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessManager {

    public static void main(String[] args) {
        String processName = "notepad.exe"; // Replace with your target process name

        try {
            if (isProcessRunning(processName)) {
                System.out.println(processName + " is running. Attempting to kill it...");
                killProcess(processName);
            } else {
                System.out.println(processName + " is not running.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isProcessRunning(String processName) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("tasklist");
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.toLowerCase().contains(processName.toLowerCase())) {
                return true;
            }
        }

        int exitCode = process.waitFor();
        return false;
    }

    private static void killProcess(String processName) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("taskkill", "/F", "/IM", processName);
        Process process = pb.start();

        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println(processName + " has been killed successfully.");
        } else {
            System.out.println("Failed to kill " + processName + ". Exit code: " + exitCode);
        }
    }
}