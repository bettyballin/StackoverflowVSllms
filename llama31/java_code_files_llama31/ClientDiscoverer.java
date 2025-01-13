/*
 * Decompiled with CFR 0.152.
 */
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClientDiscoverer {
    private static final String MULTICAST_ADDRESS = "224.0.0.1";
    private static final int MULTICAST_PORT = 12345;

    public static void main(String[] stringArray) throws Exception {
        MulticastSocket multicastSocket = new MulticastSocket(12345);
        multicastSocket.joinGroup(InetAddress.getByName(MULTICAST_ADDRESS));
        byte[] byArray = "Hello, clients!".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length, InetAddress.getByName(MULTICAST_ADDRESS), 12345);
        multicastSocket.send(datagramPacket);
        while (true) {
            byte[] byArray2 = new byte[1024];
            DatagramPacket datagramPacket2 = new DatagramPacket(byArray2, byArray2.length);
            multicastSocket.receive(datagramPacket2);
            InetAddress inetAddress = datagramPacket2.getAddress();
            int n = datagramPacket2.getPort();
            System.out.println("Client discovered: " + inetAddress.getHostAddress() + ":" + n);
        }
    }
}
