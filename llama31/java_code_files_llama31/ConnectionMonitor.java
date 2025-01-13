/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Date;

public class ConnectionMonitor {
    public static void main(String[] stringArray) {
        String string = "8.8.8.8";
        int n = 53;
        int n2 = 1000;
        while (true) {
            try (Socket socket = new Socket();){
                socket.connect(new InetSocketAddress(string, n));
                socket.setSoTimeout(n2);
                socket.getInputStream().read();
            }
            catch (SocketTimeoutException socketTimeoutException) {
                System.out.println("Connection lost at " + String.valueOf(new Date()));
            }
            catch (IOException iOException) {
                System.err.println("Error: " + iOException.getMessage());
            }
            try {
                Thread.sleep(1000L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                continue;
            }
            break;
        }
    }
}
