/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStream;
import java.net.Socket;

public class HttpClient {
    public static void main(String[] stringArray) throws Exception {
        Socket socket = new Socket("example.com", 80);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("GET / HTTP/1.1\r\nHost: example.com\r\n\r\n".getBytes());
        socket.close();
    }
}
