import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    register(selector, serverSocketChannel);
                } else if (key.isReadable()) {
                    readDataFromSocket(key);
                }
                keyIterator.remove();
            }
        }
    }

    private static void register(Selector selector, ServerSocketChannel serverSocketChannel) throws IOException {
        SocketChannel client = serverSocketChannel.accept();
        client.configureBlocking(false);

        SelectionKey key = client.register(selector, SelectionKey.OP_READ);
        ByteBuffer buffer = ByteBuffer.allocate(256);
        key.attach(buffer);
    }

    private static void readDataFromSocket(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();

        int bytesRead = client.read(buffer);

        if (bytesRead == -1) {
            client.close();
            return;
        }
        // Handle data received
    }
}