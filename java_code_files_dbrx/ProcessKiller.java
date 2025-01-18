import java.io.IOException;

public class ProcessKiller {
    public static void main(String[] args) {
        int pid = -1;
        String exeName = null;
        if (pid != -1) { // Don't execute the kill command if a suitable process ID couldn't be found
            Runtime rt = Runtime.getRuntime();
            try {
                Process killPidProcess = rt.exec("cmd /c taskkill /F /PID " + pid);
                int returnCode = killPidProcess.waitFor();
                if (returnCode > 0) { // Non-zero value indicates an error occurred while executing the command
                    // Handle the exception according to your use case
                    throw new RuntimeException("Error in killing process");
                } else {
                    System.out.println("\"" + exeName + "\" process killed.");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}