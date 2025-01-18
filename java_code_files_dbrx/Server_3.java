import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws Exception {
        // First thread
        Thread acceptorThread = new Thread(() -> {
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                InetSocketAddress inetAddressOfServer = new InetSocketAddress("localhost", 9090);

                serverSocketChannel.socket().bind(inetAddressOfServer);

                Selector selector = Selector.open();
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

                while (true) {
                    int keysReady;
                    try {
                        keysReady = selector.selectNow();
                    } catch (IOException e) {
                        throw new RuntimeException("Error in Select", e);
                    }

                    if (keysReady == 0) {
                        continue;
                    }

                    Set<SelectionKey> readyKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = readyKeys.iterator();

                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();

                        if (key.isAcceptable()) {
                            ServerSocketChannel serverSocket = (ServerSocketChannel) key.channel();
                            SocketChannel client = serverSocket.accept();
                            new MyListener(selector, client).start();
                        } else {
                            // Handle read and write events for existing connections
                        }

                        iterator.remove();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        acceptorThread.start();
    }

    // Minimal MyListener class to make the code executable
    static class MyListener extends Thread {
        private Selector selector;
        private SocketChannel client;

        public MyListener(Selector selector, SocketChannel client) {
            this.selector = selector;
            this.client = client;
        }

        @Override
        public void run() {
            // Implement the listener functionality here
        }
    }
}