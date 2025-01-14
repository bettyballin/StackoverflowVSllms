import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NonBlockingServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public NonBlockingServer(int port) throws IOException {
        this.selector = Selector.open();
        this.serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {
        try {
            while (true) {
                selector.select(); // This will block until an event occurs.

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();

                while (iter.hasNext()) {
                    SelectionKey key = iter.next();

                    if (key.isAcceptable()) {
                        accept(key);
                    } else if (key.isReadable()) {
                        read(key);
                    }

                    // Remove the key from this set once we've handled it
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel client = server.accept();

        if (client == null)
            return;

        System.out.println("Connection established with " + client.getRemoteAddress());

        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int bytesRead = client.read(buffer);

        if (bytesRead == -1) {
            // If no bytes were read, the connection was closed.
            client.close();
            return;
        }
        
        System.out.println("Received: " + new String(buffer.array(), 0, bytesRead));

        // Optionally, write a response back to the client
        ByteBuffer responseBuffer = ByteBuffer.wrap("Hello Client\n".getBytes());
        client.write(responseBuffer);
    }

    public static void main(String[] args) throws IOException {
        NonBlockingServer server = new NonBlockingServer(12345);
        new Thread(server).start();
    }
}