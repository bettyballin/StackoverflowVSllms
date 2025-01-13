/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class MessageReceiver {
    public static void main(String[] stringArray) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        byte[] byArray = new byte[4];
        dataInputStream.readFully(byArray);
        int n = ByteBuffer.wrap(byArray).getInt();
        byte[] byArray2 = new byte[n];
        dataInputStream.readFully(byArray2);
        socket.close();
    }
}
