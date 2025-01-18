interface IConnectionFactory {
    public XMPPConnection create();
}

class XMPPConnection {
    // Base class for XMPP connections
}

class SmackXMPPConnection extends XMPPConnection {
    public SmackXMPPConnection(String host, int port) {
        // Initialize connection with host and port
    }
}

class NullXMPPConnection extends XMPPConnection {
    public NullXMPPConnection(String arg) {
        // Initialize null object connection
    }
}

class RealSmackXMPPConnection implements IConnectionFactory {
    private final String host;
    private final int port;
    // ... other configuration properties if needed ...

    public RealSmackXMPPConnection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public XMPPConnection create() {
        try {
            return new SmackXMPPConnection(host, port);
            // Add additional error handling code and any other required configuration here
        } catch (Exception e) {
            System.out.println("Failed to connect to the server.");
            return new NullObjectConnection().create();
        }
    }
}

public class NullObjectConnection implements IConnectionFactory {
    private static final XMPPConnection NULL_OBJECT = createDefaultNullObjectInstance();

    @Override
    public XMPPConnection create() {
        return NULL_OBJECT; // Always returns a default null object instance.
    }

    private static XMPPConnection createDefaultNullObjectInstance() {
        return new NullXMPPConnection("");
        // Initialize the null object with any required properties or implement additional behavior depending on your use case.
    }

    public static void main(String[] args) {
        // Sample usage
        IConnectionFactory connectionFactory = new RealSmackXMPPConnection("localhost", 5222);
        XMPPConnection connection = connectionFactory.create();
        // Use the connection as needed
    }
}