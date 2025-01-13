/*
 * Decompiled with CFR 0.152.
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class NTPClient {
    public static void main(String[] stringArray) throws Exception {
        InetAddress inetAddress = InetAddress.getByName("pool.ntp.org");
        byte[] byArray = new byte[48];
        byArray[0] = 35;
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length, inetAddress, 123);
        datagramSocket.send(datagramPacket);
        byte[] byArray2 = new byte[48];
        datagramPacket = new DatagramPacket(byArray2, byArray2.length);
        datagramSocket.receive(datagramPacket);
        long l = ((long)byArray2[40] & 0xFFL) << 24 | ((long)byArray2[41] & 0xFFL) << 16 | ((long)byArray2[42] & 0xFFL) << 8 | (long)byArray2[43] & 0xFFL;
        long l2 = ((long)byArray2[44] & 0xFFL) << 24 | ((long)byArray2[45] & 0xFFL) << 16 | ((long)byArray2[46] & 0xFFL) << 8 | (long)byArray2[47] & 0xFFL;
        long l3 = l + l2 / 0x100000000L;
        System.out.println("Current time: " + l3);
    }
}
