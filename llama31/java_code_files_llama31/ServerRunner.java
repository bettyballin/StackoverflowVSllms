/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerRunner {
    private InetSocketAddress inetAdressOfServer = new InetSocketAddress("localhost", 8080);

    public void run() {
        while (true) {
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.socket().bind(this.inetAdressOfServer);
                while (true) {
                    SocketChannel socketChannel;
                    if ((socketChannel = serverSocketChannel.accept()) == null) {
                        continue;
                    }
                    new Listener("").addSocketChannel(socketChannel);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                continue;
            }
            break;
        }
    }

    public static void main(String[] stringArray) {
        ServerRunner serverRunner = new ServerRunner();
        serverRunner.run();
    }
}
