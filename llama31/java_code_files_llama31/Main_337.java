/*
 * Decompiled with CFR 0.152.
 */
import java.net.Socket;

public class Main_337 {
    public static void main(String[] stringArray) throws Exception {
        Socket socket = new Socket();
        socket.setTcpNoDelay(true);
        socket.setReceiveBufferSize(0x100000);
        socket.setSendBufferSize(0x100000);
    }
}
