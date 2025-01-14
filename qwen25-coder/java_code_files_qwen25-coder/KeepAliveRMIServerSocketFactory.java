import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMIServerSocketFactory;

public class KeepAliveRMIServerSocketFactory implements RMIServerSocketFactory {
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        return new KeepaliveSocketWrapper(port);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null && obj.getClass() == this.getClass());
    }

    @Override
    public int hashCode() {
        return 13; // a prime number
    }
}

class KeepaliveSocketWrapper extends ServerSocket {

    public KeepaliveSocketWrapper(int port) throws IOException {
        super(port);
    }

    public KeepaliveSocketWrapper(int port, int backlog) throws IOException {
        super(port, backlog);
    }

    public KeepaliveSocketWrapper(int port, int backlog, InetAddress bindAddr) throws IOException {
        super(port, backlog, bindAddr);
    }

    @Override
    public Socket accept() throws IOException {
        Socket socket = super.accept();
        socket.setKeepAlive(true);
        return socket;
    }

    public static void main(String[] args) {
    }
}