import java.lang.String;
import java.net.*;

public class SocketConfigurer {

    int reuse = 1; // or true; whatever works for you

    {
        try {
            ServerSocket socket = new ServerSocket();
            SocketAddress address = new InetSocketAddress(8080);
            socket.setReuseAddress(reuse == 1);
            socket.bind(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }

}