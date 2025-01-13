/*
 * Decompiled with CFR 0.152.
 */
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void main(String[] stringArray) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            Thread thread = new Thread((Runnable)((Object)new RequestHandler(socket)));
            thread.start();
        }
    }
}
