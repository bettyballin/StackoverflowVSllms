import javax.sql.ConnectionEventListener;
import javax.sql.ConnectionEvent;
import javax.sql.PooledConnection;

public class ConnectionErrorHandler implements ConnectionEventListener {
    @Override
    public void connectionErrorOccurred(ConnectionEvent event) {
        // Mark the connection as invalid
        event.getSource().invalidate();
    }

    @Override
    public void connectionClosed(ConnectionEvent event) {
        // Do nothing
    }

    public static void main(String[] args) {
    }
}