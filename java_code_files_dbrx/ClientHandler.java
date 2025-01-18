import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

class ClientHandler implements Runnable {
    SocketChannel client;
    String id;
    ByteBuffer buffer;

    /* Constructor and other methods go here */
    public ClientHandler(SocketChannel client, String id) {
        this.client = client;
        this.id = id;
        this.buffer = ByteBuffer.allocate(1024); // Allocate buffer with a fixed size
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Reading data from a channel when it is available,
                // instead of waiting for data to arrive (non-blocking IO)
                client.read(buffer);
                if (!buffer.hasRemaining()) break;

                /* Handle the message received */
            }
        } catch (IOException e) {
            // handle exception
        } finally {
            try {
                buffer.clear(); // Resetting buffer for later use or reuse it elsewhere in codebase.
                client.close(); // Closing a socket if an error occurs, thread is getting interrupted etc.
            } catch (IOException ex) {
                // handle exception during cleanup
            }
        }
    }
}