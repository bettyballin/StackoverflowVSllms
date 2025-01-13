import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

// Define an interface for the XMPPConnection wrapper
public interface XMPPConnectionWrapper {
    void connect() throws XMPPException;
    void disconnect();
    // Add other methods you need to use from XMPPConnection
}

// Create a wrapper class that implements the interface
public class XMPPConnectionWrapperImpl implements XMPPConnectionWrapper {
    private XMPPConnection connection;

    public XMPPConnectionWrapperImpl(XMPPConnection connection) {
        this.connection = connection;
    }

    @Override
    public void connect() throws XMPPException {
        connection.connect();
    }

    @Override
    public void disconnect() {
        connection.disconnect();
    }

    // Implement other methods
}

// Create a NullObject implementation of the interface
public class NullXMPPConnectionWrapper implements XMPPConnectionWrapper {
    @Override
    public void connect() throws XMPPException {
        // Do nothing or throw an exception
    }

    @Override
    public void disconnect() {
        // Do nothing
    }

    // Implement other methods to do nothing
}

// Create a factory method that returns the wrapper interface
public class XMPPConnectionFactory {
    public XMPPConnectionWrapper createConnection() {
        try {
            XMPPConnection connection = new XMPPConnection("your_server");
            connection.connect();
            return new XMPPConnectionWrapperImpl(connection);
        } catch (XMPPException e) {
            return new NullXMPPConnectionWrapper();
        }
    }

    public static void main(String[] args) {
        XMPPConnectionFactory factory = new XMPPConnectionFactory();
        XMPPConnectionWrapper wrapper = factory.createConnection();
        try {
            wrapper.connect();
        } catch (XMPPException e) {
            System.out.println("Failed to connect");
        }
        wrapper.disconnect();
    }
}