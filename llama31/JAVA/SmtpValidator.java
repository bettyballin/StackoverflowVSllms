import java.lang.String;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SmtpValidator {

    public static boolean isValidSmtpServer(String hostname, int port) {
        try {
            InetAddress address = InetAddress.getByName(hostname);
            Socket socket = new Socket(address, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = reader.readLine();
            if (response != null && response.startsWith("220")) {
                // Received a valid SMTP banner, so it's likely an SMTP server
                return true;
            }
        } catch (UnknownHostException e) {
            // Invalid hostname
        } catch (IOException e) {
            // Connection failed or invalid response
        }
        return false;
    }

    public static void main(String[] args) {
        String hostname = "smtp.example.com";
        int port = 25;
        boolean isValid = isValidSmtpServer(hostname, port);
        System.out.println("Is valid SMTP server: " + isValid);
    }
}