import java.io.IOException;

public class Main_450 {
    public static void main(String[] args) {
        try {
            // Use Runtime.getRuntime().exec() to execute the command
            Process process = Runtime.getRuntime().exec("taskkill /PID 1234 /F");
            int returnCode = process.waitFor();
            if (returnCode != 0) {
                System.out.println("Error executing command: " + returnCode);
            }
        } catch (IOException e) {
            System.out.println("Error executing command: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}