/*
 * Decompiled with CFR 0.152.
 */
import java.net.Socket;
import java.net.SocketException;

public class Main_561 {
    public static void main(String[] stringArray) {
        try {
            Socket socket = new Socket();
            socket.setReceiveBufferSize(0x100000);
            socket.setSendBufferSize(0x100000);
        }
        catch (SocketException socketException) {
            System.out.println("SocketException caught: " + socketException.getMessage());
        }
    }
}
