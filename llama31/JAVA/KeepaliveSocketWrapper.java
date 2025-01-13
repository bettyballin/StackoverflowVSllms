import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class KeepaliveSocketWrapper extends ServerSocket {
    private final ServerSocket delegate;

    public KeepaliveSocketWrapper(ServerSocket delegate) throws IOException {
        // Create an unbound ServerSocket to avoid "java.net.SocketException: Unbound server sockets are not implemented"
        super();
        this.delegate = delegate;
    }

    @Override
    public Socket accept() throws IOException {
        Socket s = delegate.accept();
        s.setKeepAlive(true);
        return s;
    }

    // Delegate all other methods to the original ServerSocket
    @Override
    public void bind(SocketAddress endpoint) throws IOException {
        delegate.bind(endpoint);
    }

    @Override
    public void bind(SocketAddress endpoint, int backlog) throws IOException {
        delegate.bind(endpoint, backlog);
    }

    @Override
    public InetAddress getInetAddress() {
        return delegate.getInetAddress();
    }

    @Override
    public int getLocalPort() {
        return delegate.getLocalPort();
    }

    @Override
    public SocketAddress getLocalSocketAddress() {
        return delegate.getLocalSocketAddress();
    }

    @Override
    public int getReceiveBufferSize() throws SocketException {
        return delegate.getReceiveBufferSize();
    }

    @Override
    public boolean getReuseAddress() throws SocketException {
        return delegate.getReuseAddress();
    }

    @Override
    public int getSoTimeout() throws IOException {
        return delegate.getSoTimeout();
    }

    @Override
    public boolean isBound() {
        return delegate.isBound();
    }

    @Override
    public boolean isClosed() {
        return delegate.isClosed();
    }

    @Override
    public void setReceiveBufferSize(int size) throws SocketException {
        delegate.setReceiveBufferSize(size);
    }

    @Override
    public void setReuseAddress(boolean on) throws SocketException {
        delegate.setReuseAddress(on);
    }

    @Override
    public void setSoTimeout(int timeout) throws SocketException {
        delegate.setSoTimeout(timeout);
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public void close() throws IOException {
        delegate.close();
    }

    public static void main(String[] args) {
    }
}