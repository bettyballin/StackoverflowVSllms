/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SmtpValidator {
    public static boolean isValidSmtpServer(String string, int n) {
        try {
            InetAddress inetAddress = InetAddress.getByName(string);
            Socket socket = new Socket(inetAddress, n);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String string2 = bufferedReader.readLine();
            if (string2 != null && string2.startsWith("220")) {
                return true;
            }
        }
        catch (UnknownHostException unknownHostException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return false;
    }

    public static void main(String[] stringArray) {
        String string = "smtp.example.com";
        int n = 25;
        boolean bl = SmtpValidator.isValidSmtpServer(string, n);
        System.out.println("Is valid SMTP server: " + bl);
    }
}
