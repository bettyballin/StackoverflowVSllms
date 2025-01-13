import java.lang.String;
import java.lang.Integer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class BandwidthTester {
    private static final int BUFFER_SIZE = 1 << 17;

    public static void main(String[] args) {
        try {
            // Server
            if (args.length == 0) {
                ServerSocketChannel serverChannel = ServerSocketChannel.open();
                serverChannel.bind(new InetSocketAddress(41887));

                // Wait for connection
                SocketChannel channel = serverChannel.accept();

                // Send lots of data
                sendLotsOfData(channel);
            } else if (args.length == 2) {
                String host = args[0];
                int port = Integer.parseInt(args[1]);

                System.out.println("Connecting to " + args[0] + ":" + args[1]);

                SocketChannel channel = SocketChannel.open();
                channel.connect(new InetSocketAddress(host, port));

                // Receive lots of data
                getLotsOfData(channel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getLotsOfData(SocketChannel channel) {
        System.out.println("Getting data...");
        try {
            long start = System.currentTimeMillis();

            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

            int len = channel.read(buffer);
            buffer.flip();

            while (buffer.hasRemaining()) {
                len = channel.read(buffer);
                buffer.flip();
            }

            long end = System.currentTimeMillis();

            double elapsed = ((double) (end - start)) / (1000.0);

            System.out.println("Read in " + elapsed + " seconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendLotsOfData(SocketChannel channel) {
        System.out.println("Sending data...");
        try {
            long start = System.currentTimeMillis();

            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

            int len = 1 << 29;

            for (int i = 0; i < len; i++) {
                buffer.putInt(i);
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
            }

            channel.close();

            long end = System.currentTimeMillis();

            double elapsed = ((double) (end - start)) / (1000.0);

            System.out.println("Sent in " + elapsed + " seconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}