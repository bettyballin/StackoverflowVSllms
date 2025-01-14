import java.util.HashMap;
import java.util.Map;

public class XMPPConnectionManager {
    private static final Map<String, XMPPConnection> connectionMap = new HashMap<>();

    public static synchronized XMPPConnection getConnection(String sessionId) {
        return connectionMap.get(sessionId);
    }

    public static synchronized void putConnection(String sessionId, XMPPConnection connection) {
        connectionMap.put(sessionId, connection);
    }

    public static synchronized void removeAndDisconnect(String sessionId) {
        XMPPConnection connection = connectionMap.remove(sessionId);
        if (connection != null && connection.isConnected()) {
            try {
                connection.disconnect();
            } catch (Exception e) {
                // Handle exception
            }
        }
    }

    public static void main(String[] args) {
    }
}

class XMPPConnection {
    public boolean isConnected() {
        return false;
    }

    public void disconnect() {
    }
}