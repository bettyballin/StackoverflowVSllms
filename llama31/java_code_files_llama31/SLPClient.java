/*
 * Decompiled with CFR 0.152.
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SLPClient {
    private static final int SLP_PORT = 427;

    public static void main(String[] stringArray) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();
        String string = "service:ftp";
        String string2 = "default";
        byte[] byArray = SLPClient.createSLPRequest(string, string2);
        InetAddress inetAddress = InetAddress.getByName("239.255.255.253");
        DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length, inetAddress, 427);
        datagramSocket.send(datagramPacket);
        byte[] byArray2 = new byte[1024];
        datagramPacket = new DatagramPacket(byArray2, byArray2.length);
        datagramSocket.receive(datagramPacket);
        System.out.println("SLP Response:");
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        datagramSocket.close();
    }

    private static byte[] createSLPRequest(String string, String string2) {
        String string3 = "SRVREQ service-type=\"" + string + "\" scope=\"" + string2 + "\"";
        return string3.getBytes();
    }
}
