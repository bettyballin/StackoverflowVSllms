/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class Main_180 {
    public static void main(String[] stringArray) throws UnknownHostException, IOException {
        String string = "127.0.0.1";
        int n = 12345;
        Socket socket = new Socket(string, n);
        InputStream inputStream = socket.getInputStream();
        byte[] byArray = new byte[4];
        inputStream.read(byArray);
        float f = ByteBuffer.wrap(byArray).getFloat();
        System.out.println(f);
        socket.close();
    }
}
