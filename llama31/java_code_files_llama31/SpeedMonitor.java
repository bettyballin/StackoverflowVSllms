/*
 * Decompiled with CFR 0.152.
 */
import java.net.NetworkInterface;
import java.net.SocketException;

public class SpeedMonitor {
    public static void main(String[] stringArray) throws SocketException {
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(null);
        long l = networkInterface.getMTU();
        long l2 = networkInterface.getMTU();
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
        long l3 = networkInterface.getMTU();
        long l4 = networkInterface.getMTU();
        long l5 = (l3 - l) / 1024L;
        long l6 = (l4 - l2) / 1024L;
        System.out.println("Download Speed: " + l5 + " KB/s");
        System.out.println("Upload Speed: " + l6 + " KB/s");
    }
}
