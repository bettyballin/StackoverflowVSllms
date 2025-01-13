/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.net.Socket;

public class Main_775 {
    public static void main(String[] stringArray) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        InputStream inputStream = socket.getInputStream();
        int n = inputStream.read();
        if (n == -1) {
            System.out.println("Remote side socket close detected");
        }
        socket.close();
    }
}
