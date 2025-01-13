/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpConnectionManager {
    public static void main(String[] stringArray) {
        TcpConnectionManager tcpConnectionManager = new TcpConnectionManager();
        tcpConnectionManager.connectToServer();
    }

    public void connectToServer() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8000);
            if (socket.isConnected()) {
                System.out.println("The connection is active");
            } else {
                System.out.println("The connection is not active");
            }
        }
        catch (UnknownHostException unknownHostException) {
            System.out.println("Unknown host: " + unknownHostException.getMessage());
        }
        catch (IOException iOException) {
            System.out.println("I/O error: " + iOException.getMessage());
        }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                }
                catch (IOException iOException) {
                    System.out.println("Error closing socket: " + iOException.getMessage());
                }
            }
        }
    }
}
