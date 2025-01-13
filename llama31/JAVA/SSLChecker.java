import java.lang.String;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SSLChecker {
    public static void main(String[] args) throws IOException {
        String serverIP = "example.com";
        int serverPort = 443;

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        Socket socket = factory.createSocket(InetAddress.getByName(serverIP), serverPort);

        if (socket.isConnected()) {
            System.out.println("Server has SSL enabled");
        } else {
            System.out.println("Server does not have SSL enabled");
        }
    }
}