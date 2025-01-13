import java.lang.String;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class NTPClient {
    public static void main(String[] args) throws Exception {
        // NTP server address
        InetAddress address = InetAddress.getByName("pool.ntp.org");

        // NTP request packet
        byte[] request = new byte[48];
        request[0] = 0x23; // LI = 0, VN = 3, Mode = 3

        // Send request
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(request, request.length, address, 123);
        socket.send(packet);

        // Receive response
        byte[] response = new byte[48];
        packet = new DatagramPacket(response, response.length);
        socket.receive(packet);

        // Extract timestamp
        long seconds = ((long) response[40] & 0xff) << 24
                | ((long) response[41] & 0xff) << 16
                | ((long) response[42] & 0xff) << 8
                | ((long) response[43] & 0xff);
        long fraction = ((long) response[44] & 0xff) << 24
                | ((long) response[45] & 0xff) << 16
                | ((long) response[46] & 0xff) << 8
                | ((long) response[47] & 0xff);

        // Calculate timestamp
        long timestamp = seconds + fraction / (1L << 32);

        System.out.println("Current time: " + timestamp);
    }
}