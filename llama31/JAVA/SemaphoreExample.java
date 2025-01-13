import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SemaphoreExample {
    public static void main(String[] args) {
        // Create a table to act as a semaphore
        // This should be done in a database setup script or through a database administration tool
        // CREATE TABLE MY_SEMAPHORE (ID INT PRIMARY KEY, LOCKED SMALLINT);

        // Acquire lock
        try (Connection conn = DriverManager.getConnection("url", "user", "password")) {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE MY_SEMAPHORE SET LOCKED = 1 WHERE ID = 1 AND LOCKED = 0");
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 1) {
                // Perform updates
                System.out.println("Lock acquired, performing updates");
            } else {
                // Lock is already held by another node
                System.out.println("Lock is already held by another node");
            }

            // Release lock
            pstmt = conn.prepareStatement("UPDATE MY_SEMAPHORE SET LOCKED = 0 WHERE ID = 1");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}