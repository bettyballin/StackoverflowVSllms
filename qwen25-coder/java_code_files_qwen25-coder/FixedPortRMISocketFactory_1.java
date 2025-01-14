import java.rmi.RMISocketFactory;
import java.net.ServerSocket;
import java.net.Socket;

public class FixedPortRMISocketFactory_1 extends RMISocketFactory {
    private final int clientListenPort;

    public FixedPortRMISocketFactory_1(int client_listen_port) {
        this.clientListenPort = client_listen_port;
    }

    @Override
    public Socket createSocket(String host, int port) throws java.io.IOException {
        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws java.io.IOException {
        if (port == 0) {
            port = clientListenPort;
        }
        return new ServerSocket(port);
    }

    public static void registerFactory(int client_listen_port) throws Exception {
        RMISocketFactory.setSocketFactory(new FixedPortRMISocketFactory_1(client_listen_port));
    }

    public static void main(String[] args) {
    }
}