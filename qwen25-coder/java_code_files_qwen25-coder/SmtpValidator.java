import java.lang.String;
import java.net.Socket;

public class SmtpValidator {
    public static boolean isValidSmtpServer(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true; // Connection successful, likely an SMTP server
        } catch (Exception e) {
            return false; // Connection failed
        }
    }

    public static void main(String[] args) {
        String host = "smtp.example.com"; // User input
        int port = 25; // Common SMTP Port

        boolean isValid = isValidSmtpServer(host, port);
        System.out.println("Is the server a valid SMTP server?: " + isValid);
    }
}