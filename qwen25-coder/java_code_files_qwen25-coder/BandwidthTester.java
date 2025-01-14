import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;

public class BandwidthTester {
    private static final int BUFFER_SIZE = (1 << 20); // 1MB buffer size

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(41887));

                SocketChannel sock = serverSocketChannel.accept();

                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                sendLotsOfData(sock, buffer);

                serverSocketChannel.close();
            } else if (args.length == 2) {
                String host = args[0];
                int port = Integer.parseInt(args[1]);

                SocketChannel sock = SocketChannel.open(new InetSocketAddress(host, port));
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                getLotsOfData(sock, buffer);

                sock.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getLotsOfData(SocketChannel in, ByteBuffer buffer) throws IOException {
        long start = System.currentTimeMillis();

        buffer.clear();
        in.read(buffer);
        buffer.flip();

        int len = buffer.getInt();
        for (int i = 0; i < len && buffer.hasRemaining(); i++) {
            buffer.getInt();
        }

        long end = System.currentTimeMillis();
        double elapsed = (end - start) / 1000.0;
        System.out.println("Read in " + elapsed + " seconds: " + (4.0 * 8.0 * len / elapsed) + " bits per second");
    }

    public static void sendLotsOfData(SocketChannel out, ByteBuffer buffer) throws IOException {
        int len = (1 << 27); // Adjust this to control the amount of data sent

        long start = System.currentTimeMillis();

        buffer.putInt(len);
        for (int i = 0; i < len; i++) {
            buffer.putInt(i);
            if (!buffer.hasRemaining()) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }

        if (buffer.position() > 0) {
            buffer.flip();
            out.write(buffer);
        }

        long end = System.currentTimeMillis();
        double elapsed = (end - start) / 1000.0;
        System.out.println("Sent in " + elapsed + " seconds: " + (4.0 * 8.0 * len / elapsed) + " bits per second");
    }
}