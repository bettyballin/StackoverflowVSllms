import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Timestamp timestamp = null;
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO mst(time) VALUES (?)");  // Create prepared statement with placeholder for time
        stmt.setTimestamp(1, timestamp);  // Set the first parameter of PreparedStatement object to Timestamp value
        // Execute query
        stmt.executeUpdate();
    }
}