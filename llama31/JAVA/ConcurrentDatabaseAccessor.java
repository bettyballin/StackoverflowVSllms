import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConcurrentDatabaseAccessor {
    public static void main(String[] args) {
        try {
            // Create two separate connections
            Connection conn1 = DriverManager.getConnection("url", "user", "password");
            Connection conn2 = DriverManager.getConnection("url", "user", "password");

            // Create prepared statements on each connection
            PreparedStatement pstmt1 = conn1.prepareStatement("query1");
            PreparedStatement pstmt2 = conn2.prepareStatement("query2");

            // Execute queries concurrently
            pstmt1.executeQuery();
            pstmt2.executeQuery();

            // Close connections and prepared statements
            pstmt1.close();
            pstmt2.close();
            conn1.close();
            conn2.close();
        } catch (SQLException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        }
    }
}