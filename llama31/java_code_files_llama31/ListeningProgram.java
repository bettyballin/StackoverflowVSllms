/*
 * Decompiled with CFR 0.152.
 */
import java.net.ServerSocket;
import java.net.Socket;

public class ListeningProgram {
    public static void main(String[] stringArray) throws Exception {
        int n = 8080;
        ServerSocket serverSocket = new ServerSocket(n);
        System.out.println("Listening on port " + n);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Incoming connection from " + String.valueOf(socket.getInetAddress()));
        }
    }
}
