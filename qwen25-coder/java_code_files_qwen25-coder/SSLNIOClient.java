import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class SSLNIOClient {
    public static void main(String[] args) throws Exception {
        // Setup Selector
        Selector selector = Selector.open();
        
        // Setup SocketChannel and connect to server
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("example.com", 443));
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_CONNECT);

        // Setup SSLContext and SSLEngine
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, null); // For simplicity using default trust manager
        SSLEngine sslEngine = sslContext.createSSLEngine("example.com", 443);
        sslEngine.setUseClientMode(true);

        // Buffers for sending and receiving data
        ByteBuffer appInBuffer = ByteBuffer.allocate(8192);
        ByteBuffer appOutBuffer = ByteBuffer.wrap("Hello, World!".getBytes());
        
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey k = iterator.next();

                if (!k.isValid()) {
                    iterator.remove();
                    continue;
                }

                if (k.isConnectable()) {
                    finishConnection(k, sslEngine);
                } 
                if (k.isWritable() && appOutBuffer.hasRemaining()) {
                    doWrite(k, appOutBuffer, sslEngine);
                } 
                if (k.isReadable()) {
                    doRead(k, appInBuffer, sslEngine);
                }

                iterator.remove();
            }
        }
    }

    private static void finishConnection(SelectionKey key, SSLEngine engine) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        if (socketChannel.finishConnect()) {
            // Switch to OP_READ and OP_WRITE to start handshake
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            engine.beginHandshake();
            handleHandshake(socketChannel, engine);
        } else {
            key.cancel();
        }
    }

    private static void doWrite(SelectionKey k, ByteBuffer appOutBuffer, SSLEngine sslEngine) throws IOException {
        SocketChannel socketChannel = (SocketChannel) k.channel();

        ByteBuffer netOutBuffer = ByteBuffer.allocate(sslEngine.getSession().getPacketBufferSize());
        SSLEngineResult result;
        do {
            result = sslEngine.wrap(appOutBuffer, netOutBuffer);
            handleHandshake(socketChannel, sslEngine);
        } while (result.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW);

        netOutBuffer.flip();
        while (netOutBuffer.hasRemaining()) {
            socketChannel.write(netOutBuffer);
        }
        netOutBuffer.compact();

        if (!appOutBuffer.hasRemaining()) {
            k.interestOps(k.interestOps() & ~SelectionKey.OP_WRITE | SelectionKey.OP_READ);
        }
    }

    private static void doRead(SelectionKey key, ByteBuffer appInBuffer, SSLEngine sslEngine) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        ByteBuffer netInBuffer = ByteBuffer.allocate(sslEngine.getSession().getPacketBufferSize());
        int bytesRead = socketChannel.read(netInBuffer);
        if (bytesRead == -1) {
            sslEngine.closeInbound();
            socketChannel.close();
            return;
        }

        netInBuffer.flip();
        SSLEngineResult result = sslEngine.unwrap(netInBuffer, appInBuffer);
        handleHandshake(socketChannel, sslEngine);

        switch (result.getStatus()) {
            case BUFFER_OVERFLOW:
                // Handle overflow
                break;
            case BUFFER_UNDERFLOW:
                // Handle underflow
                break;
            case CLOSED:
                sslEngine.closeInbound();
                socketChannel.close();
                break;
            case OK:
                appInBuffer.flip();
                while (appInBuffer.hasRemaining()) {
                    char ch = (char) appInBuffer.get();
                    System.out.print(ch);
                }
                appInBuffer.compact();
                break;
        }

        netInBuffer.compact();
    }

    private static void handleHandshake(SocketChannel channel, SSLEngine sslEngine) throws IOException {
        SSLEngineResult.HandshakeStatus handshakeStatus = sslEngine.getHandshakeStatus();

        while (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK ||
               handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP ||
               handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            switch (handshakeStatus) {
                case NEED_TASK:
                    Runnable task;
                    while ((task = sslEngine.getDelegatedTask()) != null) {
                        task.run();
                    }
                    handshakeStatus = sslEngine.getHandshakeStatus();
                    break;
                case NEED_UNWRAP:
                    // No data to read, exit and wait for more data
                    return;
                case NEED_WRAP:
                    ByteBuffer netOutBuffer = ByteBuffer.allocate(sslEngine.getSession().getPacketBufferSize());
                    SSLEngineResult wrapResult = sslEngine.wrap(ByteBuffer.allocate(0), netOutBuffer);
                    netOutBuffer.flip();
                    while (netOutBuffer.hasRemaining()) {
                        channel.write(netOutBuffer);
                    }
                    netOutBuffer.compact();
                    handshakeStatus = wrapResult.getHandshakeStatus();
                    break;
                default:
                    break;
            }
        }
    }
}