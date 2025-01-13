/*
 * Decompiled with CFR 0.152.
 */
import java.net.Socket;

public class Main_336 {
    public static void main(String[] stringArray) throws Exception {
        Socket socket = new Socket();
        socket.setKeepAlive(true);
        socket.setSoTimeout(30000);
    }
}
