/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStream;
import java.net.Socket;

public class NetworkTester {
    public static void main(String[] stringArray) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello, server!".getBytes());
        outputStream.close();
        socket.close();
    }
}
