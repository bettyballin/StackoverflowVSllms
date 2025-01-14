import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedPortRMISocketFactory extends RMISocketFactory {
    private List<Integer> ports;
    private AtomicInteger portIndex = new AtomicInteger(0);

    public FixedPortRMISocketFactory(List<Integer> ports) {
        this.ports = ports;
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        // Use the next available fixed port or throw if no more are available
        synchronized (portIndex) {
            int idx = portIndex.getAndIncrement();
            if (idx >= ports.size()) {
                throw new IllegalArgumentException("No more available ports");
            }
            return new ServerSocket(ports.get(idx));
        }
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        // Connect using these fixed ports only
        for (Integer p : ports) {
            try {
                return new Socket(host, p);
            } catch (IOException e) {
                continue; // try the next port
            }
        }
        throw new IOException("All specified ports are unavailable");
    }

    public static void main(String[] args) throws Exception {
        List<Integer> ports = Arrays.asList(2001, 2002, 2003); // Your list of allowed ports
        FixedPortRMISocketFactory socketFactory = new FixedPortRMISocketFactory(ports);
        RMISocketFactory.setSocketFactory(socketFactory);

        // Further RMI setup code here...
    }
}