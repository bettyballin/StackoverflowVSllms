import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args) {
        try{
            int connectTimeout = 10 * 1000; // in milliseconds, specify according to your requirement
            String serverIP = "127.0.0.1";
            int port = 12345;
            SocketAddress addr = new InetSocketAddress(serverIP, port);
            SocketChannel socketChannel = SocketChannel.open();
            // Also you can set non-blocking mode on this channel before calling finishConnection() depending upon your requirement.
            socketChannel.configureBlocking(false); // set non-blocking mode
            socketChannel.connect(addr);
            boolean connected = socketChannel.finishConnect(); // This will return false if connection times out or fails.
            System.out.println("Connected: " + connected);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}