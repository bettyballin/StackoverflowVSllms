/*
 * Decompiled with CFR 0.152.
 */
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {
    private static final String MULTICAST_ADDRESS = "224.0.0.1";
    private static final int MULTICAST_PORT = 12345;

    public static void main(String[] stringArray) throws Exception {
        MulticastSocket multicastSocket = new MulticastSocket(12345);
        multicastSocket.joinGroup(InetAddress.getByName(MULTICAST_ADDRESS));
        while (true) {
            byte[] byArray = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
            multicastSocket.receive(datagramPacket);
            if (!new String(datagramPacket.getData()).equals("Hello, clients!")) continue;
            byte[] byArray2 = "Hello, server!".getBytes();
            DatagramPacket datagramPacket2 = new DatagramPacket(byArray2, byArray2.length, datagramPacket.getAddress(), datagramPacket.getPort());
            multicastSocket.send(datagramPacket2);
        }
    }
}
