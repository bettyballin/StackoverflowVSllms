import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;

public class SpeedMonitor {
    public static void main(String[] args) throws SocketException {
        NetworkInterface netInt = NetworkInterface.getByInetAddress(null);

        long previous_rx = netInt.getMTU();
        long previous_tx = netInt.getMTU();

        try {
            Thread.sleep(1000); // Wait 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long current_rx = netInt.getMTU();
        long current_tx = netInt.getMTU();

        long download_speed = (current_rx - previous_rx) / 1024; // KB/s
        long upload_speed = (current_tx - previous_tx) / 1024; // KB/s

        System.out.println("Download Speed: " + download_speed + " KB/s");
        System.out.println("Upload Speed: " + upload_speed + " KB/s");
    }
}