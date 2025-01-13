/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketManager {
    public static void main(String[] stringArray) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
        }
        catch (IOException iOException) {
        }
        finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                }
                catch (IOException iOException) {}
            }
        }
    }
}
