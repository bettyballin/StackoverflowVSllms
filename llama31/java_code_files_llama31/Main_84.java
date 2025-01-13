/*
 * Decompiled with CFR 0.152.
 */
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main_84 {
    public static void main(String[] stringArray) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.setSendBufferSize(512);
        }
        catch (SocketException socketException) {
            System.out.println("Error creating or configuring the socket: " + socketException.getMessage());
        }
    }
}
