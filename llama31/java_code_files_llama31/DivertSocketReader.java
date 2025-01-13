/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class DivertSocketReader {
    public static void main(String[] stringArray) throws Exception {
        int n;
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 1234));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while ((n = socketChannel.read(byteBuffer)) != -1) {
            byte[] byArray = new byte[n];
            byteBuffer.flip();
            byteBuffer.get(byArray);
            DivertSocketReader.processPacket(byArray);
        }
        socketChannel.close();
    }

    private static void processPacket(byte[] byArray) {
    }
}
