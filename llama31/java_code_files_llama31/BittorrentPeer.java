/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class BittorrentPeer {
    public static void main(String[] stringArray) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 6881));
        byte[] byArray = "Handshake message".getBytes();
        socketChannel.write(ByteBuffer.wrap(byArray));
        ByteBuffer byteBuffer = ByteBuffer.allocate(68);
        socketChannel.read(byteBuffer);
        int n = 0;
        int n2 = 1024;
        PieceRequest pieceRequest = new PieceRequest(n, n2);
        socketChannel.write(ByteBuffer.wrap(pieceRequest.getMessage()));
        Selector selector = Selector.open();
        socketChannel.register(selector, 1);
        block0: while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (true) {
                if (!iterator.hasNext()) continue block0;
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    ByteBuffer byteBuffer2 = ByteBuffer.allocate(n2);
                    socketChannel.read(byteBuffer2);
                }
                iterator.remove();
            }
            break;
        }
    }
}
