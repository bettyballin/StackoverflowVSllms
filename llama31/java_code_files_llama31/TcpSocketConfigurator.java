/*
 * Decompiled with CFR 0.152.
 */
import java.net.Socket;
import java.net.StandardSocketOptions;

public class TcpSocketConfigurator {
    public static void main(String[] stringArray) throws Exception {
        Socket socket = new Socket();
        socket.setOption(StandardSocketOptions.IP_TOS, 0);
    }
}
