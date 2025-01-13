import java.sql.*;
import org.joda.time.DateTime;

public class TimeInserter {
    public static void main(String[] args) throws SQLException {
        // Connect to the database
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase", "username", "password");

        // Create a prepared statement
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO mst(time) VALUES (?);");

        // Create a DateTime object
        DateTime dt = new DateTime();

        // Convert DateTime to Timestamp
        java.sql.Timestamp ts = new java.sql.Timestamp(dt.getMillis());

        // Set the timestamp on the prepared statement
        pstmt.setTimestamp(1, ts);

        // Execute the prepared statement
        pstmt.executeUpdate();

        // Close the connection
        conn.close();
    }
}