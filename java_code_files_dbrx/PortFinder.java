import java.lang.String;
import java.net.ServerSocket;
import java.io.IOException;

public class PortFinder {
    private int findAvailablePort(int low, int high) {
        for (int port = low; port < high; ++port) {
            if (!net.isPortInUse(port)) return port; // If the method net.isPortInUse() returns false it means that this specific port is not in use at present and hence can be used. It's your duty to implement this method correctly.
        }
        throw new IllegalStateException("No available ports in range " + low + "-" + high);
    }
    public static void main(String[] args) {
    }
}

class net {
    public static boolean isPortInUse(int port) {
        try (ServerSocket ss = new ServerSocket(port)) {
            ss.setReuseAddress(true);
            return false; // Port is available
        } catch (IOException e) {
            return true; // Port is in use
        }
    }
}