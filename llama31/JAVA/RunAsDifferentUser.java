import java.lang.String;
import java.io.IOException;

public class RunAsDifferentUser {
    public static void main(String[] args) {
        String username = "differentUser";
        String password = "password";
        String command = "notepad.exe";

        ProcessBuilder processBuilder = new ProcessBuilder("runas", "/user:" + username, command);
        processBuilder.environment().put("password", password);

        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}