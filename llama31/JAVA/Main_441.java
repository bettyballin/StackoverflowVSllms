import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main_441 {
    public static void main(String[] args) {
        try {
            // Get the client's IP address
            // NOTE: Since this is a standalone Java program, there is no 'request' object.
            // For demonstration purposes, we'll use the local machine's IP address.
            String ipAddress = InetAddress.getLocalHost().getHostAddress();

            // Get the client's MAC address from the ARP cache
            InetAddress address = InetAddress.getByName(ipAddress);
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
            byte[] macAddressBytes = networkInterface.getHardwareAddress();

            // Convert the MAC address bytes to a string
            StringBuilder macAddressBuilder = new StringBuilder();
            for (byte b : macAddressBytes) {
                macAddressBuilder.append(String.format("%02X:", b));
            }
            String macAddress = macAddressBuilder.substring(0, macAddressBuilder.length() - 1);

            System.out.println("IP Address: " + ipAddress);
            System.out.println("MAC Address: " + macAddress);
        } catch (UnknownHostException | SocketException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}