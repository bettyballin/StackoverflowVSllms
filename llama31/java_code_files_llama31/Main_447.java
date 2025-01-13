/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main_447 {
    public static void main(String[] stringArray) {
        try {
            InetAddress inetAddress = InetAddress.getByName("example.com");
            Socket socket = new Socket(inetAddress, 80);
        }
        catch (UnknownHostException unknownHostException) {
            System.out.println(unknownHostException.getMessage());
        }
        catch (SocketException socketException) {
            System.out.println(socketException.getMessage());
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
