import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

public class MyRMISocketFactory extends RMISocketFactory {
    private String user;

    public MyRMISocketFactory(String user) {
        this.user = user;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return innerCreateSocket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket serverSocket = innerCreateServerSocket(port);
        // Here you could wrap the server socket if needed.
        return serverSocket;
    }

    private Socket innerCreateSocket(String host, int port) throws IOException {
        System.setSecurityManager(new NativeRMISecurityManager(user));
        return new Socket(host, port);
    }

    private ServerSocket innerCreateServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    public static void main(String[] args) throws Exception {
        String user = "my_user";
        MyRMISocketFactory myRMISocketFactory = new MyRMISocketFactory(user);

        RMISocketFactory.setSocketFactory(myRMISocketFactory);
        // Start server or client as per your application.
    }
}

class NativeRMISecurityManager extends SecurityManager {
    private String user;

    public NativeRMISecurityManager(String user) {
        this.user = user;
    }

    // Implement necessary methods if needed
}