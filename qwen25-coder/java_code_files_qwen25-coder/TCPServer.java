import java.lang.String;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9000));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int readyChannels = selector.select();

            if (readyChannels == 0) continue;

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    acceptConnection(serverSocketChannel, selector);
                } else if (key.isReadable()) {
                    handleRead(key);
                }
                keyIterator.remove(); // Important to remove the key once processed
            }
        }
    }

    private static void acceptConnection(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        SocketChannel client = serverSocketChannel.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key) {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int bytesRead = clientChannel.read(buffer);
            if (bytesRead == -1) {
                // This means the other side has closed the connection
                clientChannel.close();
                System.out.println("Client disconnected!");
            } else if (bytesRead > 0) {
                // Process data read from the client
                buffer.flip();
                byte[] bytes = new byte[buffer.limit()];
                buffer.get(bytes);
                String message = new String(bytes).trim();
                System.out.println("Received: " + message);

                // Echo the received message back to the client
                clientChannel.write(ByteBuffer.wrap((message + "\n").getBytes()));
            }
        } catch (IOException e) {
            try {
                clientChannel.close();
            } catch (IOException e1) {
                System.err.println("Failed to close client channel: " + e1.getMessage());
            }
        }
    }
}