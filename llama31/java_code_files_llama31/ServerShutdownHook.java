/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.ServerSocket;

public class ServerShutdownHook {
    private static ServerSocket serverSocket;

    public static void main(String[] stringArray) throws IOException {
        serverSocket = new ServerSocket(8080);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                serverSocket.close();
            }
            catch (IOException iOException) {
                System.err.println("Error closing server socket: " + iOException.getMessage());
            }
        }));
    }
}
