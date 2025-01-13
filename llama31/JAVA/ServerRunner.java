import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerRunner {
    private InetSocketAddress inetAdressOfServer = new InetSocketAddress("localhost", 8080);

    public void run() {
        while (true) {
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.socket().bind(inetAdressOfServer);

                while (true) {
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    if (clientChannel != null) {
                        new Listener("").addSocketChannel(clientChannel);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ServerRunner serverRunner = new ServerRunner();
        serverRunner.run();
    }
}

class Listener {
    private String name;

    public Listener(String name) {
        this.name = name;
    }

    public void addSocketChannel(SocketChannel socketChannel) {
        System.out.println("Client connected: " + socketChannel);
    }
}