import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseBatchInserter {
    public static void main(String[] args) {
        // Create a connection to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("your_database_url", "your_username", "your_password");

            // Create a PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DST_Table (c1, c5, c6) VALUES (?, ?, ?)");

            // Add rows to the batch
            pstmt.setInt(1, 1); // Replace with actual value for c1
            pstmt.setInt(2, 2); // Replace with actual value for c5
            pstmt.setInt(3, 3); // Replace with actual value for c6
            pstmt.addBatch();

            // Add more rows to the batch
            // ...

            // Execute the batch
            pstmt.executeBatch();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}