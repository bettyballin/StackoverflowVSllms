/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientLoop {
    public static void main(String[] stringArray) {
        try {
            Socket socket = new Socket("localhost", 4448);
            socket.setKeepAlive(true);
            socket.setReuseAddress(true);
            OutputStream outputStream = socket.getOutputStream();
            int n = 0;
            while (true) {
                try {
                    while (true) {
                        outputStream.write((byte)n++);
                        outputStream.flush();
                        Thread.sleep(1000L);
                        outputStream.close();
                        socket.close();
                        socket = new Socket("localhost", 4448);
                        socket.setKeepAlive(true);
                        socket.setReuseAddress(true);
                        outputStream = socket.getOutputStream();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    System.err.println("ERROR: reconnecting...");
                    try {
                        Thread.sleep(5000L);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }
                break;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("ERROR: could not connect");
            return;
        }
    }
}
