import java.rmi.server.RMISocketFactory;
import java.net.SocketFactory;

public class RMIConfigurator {
    public static void main(String[] args) {
        RMISocketFactory.setSocketFactory(new CustomRMISocketFactory(1099, 1109));
    }
}

class CustomRMISocketFactory implements RMISocketFactory {
    private int port1;
    private int port2;

    public CustomRMISocketFactory(int port1, int port2) {
        this.port1 = port1;
        this.port2 = port2;
    }

    @Override
    public Socket createSocket(String host, int port) {
        // implement your custom socket creation logic here
        return new Socket();
    }

    @Override
    public ServerSocket createServerSocket(int port) {
        // implement your custom server socket creation logic here
        return new ServerSocket(port);
    }
}