/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DistanceVectorRouting {
    public static void main(String[] stringArray) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(4445, InetAddress.getByName("127.0.0.1"));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            try {
                while (true) {
                    byte[] byArray = new byte[2000];
                    DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
                    datagramSocket.receive(datagramPacket);
                    executorService.submit(new DatagramProcessor(datagramPacket));
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                continue;
            }
            break;
        }
    }
}
