import java.lang.String;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class OracleDatabaseScanner {

    public static void main(String[] args) {
        String subnet = "192.168.1"; // Change to your subnet
        int startIP = 1; // Start of the IP range (inclusive)
        int endIP = 254; // End of the IP range (inclusive)
        
        for (int i = startIP; i <= endIP; i++) {
            String ip = subnet + "." + i;
            try {
                if (isHostActive(ip)) {
                    System.out.println("Host " + ip + " is active. Checking Oracle DB...");
                    if (isOracleDBRunning(ip, 1521)) {
                        System.out.println("Possible Oracle DB found on: " + ip);
                    } else {
                        System.out.println("No Oracle DB detected on: " + ip);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isHostActive(String ipAddress) throws IOException {
        InetAddress address = InetAddress.getByName(ipAddress);
        return address.isReachable(100); // Timeout in milliseconds
    }

    private static boolean isOracleDBRunning(String ipAddress, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new java.net.InetSocketAddress(ipAddress, port), 500); // Timeout in milliseconds
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}