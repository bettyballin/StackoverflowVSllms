import java.sql.Connection;
import java.sql.SQLException;

public class SafeConnectionUsage {

    public void useConnection(Connection conn) {
        try {
            // Attempt to exit DBMS_FLASHBACK mode
            // execute your code here...
            conn.createStatement(); // Added to allow SQLException to be thrown
        } catch (SQLException e) {
            // Mode exit failed, close the connection directly
            closeConnection(conn);
            throw new RuntimeException("Failed to reset session state", e);
        } finally {
            // Ensure the connection is closed if not already
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignore) {
                    // Log or handle this in a more sophisticated way if necessary
                }
            }
        }
    }

    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // Handle exception as appropriate, logging might be useful here
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // SafeConnectionUsage usage = new SafeConnectionUsage();
        // Connection conn = ... // obtain a Connection
        // usage.useConnection(conn);
    }
}