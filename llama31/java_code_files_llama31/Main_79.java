/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStream;
import java.net.Socket;

public class Main_79 {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = new byte[]{0, 0, 0, 1, 0};
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(byArray);
        outputStream.close();
        socket.close();
    }
}
