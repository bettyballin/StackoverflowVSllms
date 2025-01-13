/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Main_776 {
    public static void main(String[] stringArray) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8080);
            InputStream inputStream = socket.getInputStream();
            inputStream.read();
        }
        catch (IOException iOException) {
            System.out.println("An I/O error occurred: " + iOException.getMessage());
        }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                }
                catch (IOException iOException) {
                    System.out.println("Failed to close the socket: " + iOException.getMessage());
                }
            }
        }
    }
}
