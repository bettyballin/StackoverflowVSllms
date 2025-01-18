import java.lang.String;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.rmi.server.RMISocketFactory;

public class MySocketFactory extends RMISocketFactory {
    private int specifiedPort;

    public MySocketFactory(int specifiedPort) {
        this.specifiedPort = specifiedPort;
    }

    public Socket createSocket(String host, int port) throws IOException {
        return new Socket(host, specifiedPort);
    }

    public ServerSocket createServerSocket(int port) throws IOException {
        return new ServerSocket(specifiedPort);
    }

    public static void main(String[] args) {
        // You can add code here to test MySocketFactory if needed
    }
}