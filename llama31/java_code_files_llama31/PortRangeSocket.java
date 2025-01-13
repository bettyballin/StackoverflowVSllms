/*
 * Decompiled with CFR 0.152.
 */
import java.net.DatagramSocket;
import java.net.SocketException;

public class PortRangeSocket {
    public static void main(String[] stringArray) {
        int n = 4000;
        int n2 = 5000;
        for (int i = n; i <= n2; ++i) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(i);
                System.out.println("Bound to port: " + i);
                break;
            }
            catch (SocketException socketException) {
                System.out.println("Port " + i + " is in use.");
                continue;
            }
        }
    }
}
