/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class BandwidthTester {
    private static final int BUFFER_SIZE = 131072;

    public static void main(String[] stringArray) {
        try {
            if (stringArray.length == 0) {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.bind(new InetSocketAddress(41887));
                SocketChannel socketChannel = serverSocketChannel.accept();
                BandwidthTester.sendLotsOfData(socketChannel);
            } else if (stringArray.length == 2) {
                String string = stringArray[0];
                int n = Integer.parseInt(stringArray[1]);
                System.out.println("Connecting to " + stringArray[0] + ":" + stringArray[1]);
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.connect(new InetSocketAddress(string, n));
                BandwidthTester.getLotsOfData(socketChannel);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void getLotsOfData(SocketChannel socketChannel) {
        System.out.println("Getting data...");
        try {
            long l = System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(131072);
            int n = socketChannel.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                n = socketChannel.read(byteBuffer);
                byteBuffer.flip();
            }
            long l2 = System.currentTimeMillis();
            double d = (double)(l2 - l) / 1000.0;
            System.out.println("Read in " + d + " seconds");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void sendLotsOfData(SocketChannel socketChannel) {
        System.out.println("Sending data...");
        try {
            long l = System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(131072);
            int n = 0x20000000;
            for (int i = 0; i < n; ++i) {
                byteBuffer.putInt(i);
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            socketChannel.close();
            long l2 = System.currentTimeMillis();
            double d = (double)(l2 - l) / 1000.0;
            System.out.println("Sent in " + d + " seconds");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
