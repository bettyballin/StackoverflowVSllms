import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class MyListener {

    class MyListenerThread extends Thread {
        private final Selector selector;
        private final SocketChannel clientSocket;

        public MyListenerThread(Selector sel, SocketChannel socket) throws IOException {
            this.selector = sel;
            this.clientSocket = socket;
            clientSocket.configureBlocking(false);
        }

        @Override
        public void run() {
            try {
                clientSocket.register(this.selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            } catch (Exception e) {
                System.out.println("Error in registration: " + e);
            }
        }
    }

    public static void main(String[] args) {
    }

}