/*
 * Decompiled with CFR 0.152.
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Main_108 {
    public static void main(String[] stringArray) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] byArray = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length, new InetSocketAddress("client2_ip", 5678));
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
