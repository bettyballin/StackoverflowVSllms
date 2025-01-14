import java.net.Socket;
import javax.net.SocketFactory;
import java.lang.reflect.Field;
import java.net.InetAddress;

public class CustomSocketFactory extends SocketFactory {
    private final SocketFactory originalSocketFactory = SocketFactory.getDefault();

    @Override
    public Socket createSocket() {
        // Add your custom socket initialization here
        try {
            return new Socket();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Socket createSocket(String host, int port) {
        // Custom implementation
        try {
            return originalSocketFactory.createSocket(host, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) {
        // Custom implementation
        try {
            return originalSocketFactory.createSocket(host, port, localHost, localPort);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Socket createSocket(InetAddress host, int port) {
        // Custom implementation
        try {
            return originalSocketFactory.createSocket(host, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) {
        // Custom implementation
        try {
            return originalSocketFactory.createSocket(address, port, localAddress, localPort);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setDefault(SocketFactory factory) {
        try {
            Field field = SocketFactory.class.getDeclaredField("defaultFactory");
            field.setAccessible(true);
            field.set(null, factory);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set default socket factory", e);
        }
    }

    public static void main(String[] args) {
        CustomSocketFactory customFactory = new CustomSocketFactory();
        CustomSocketFactory.setDefault(customFactory);

        // Now, the default SocketFactory is your custom implementation
    }
}