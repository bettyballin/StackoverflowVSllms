/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class Main_181 {
    public static void main(String[] stringArray) throws UnknownHostException, IOException {
        float f = 3.14f;
        byte[] byArray = new byte[4];
        ByteBuffer.wrap(byArray).putFloat(f);
        String string = "localhost";
        int n = 8080;
        Socket socket = new Socket(string, n);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(byArray);
        outputStream.flush();
        socket.close();
    }
}
