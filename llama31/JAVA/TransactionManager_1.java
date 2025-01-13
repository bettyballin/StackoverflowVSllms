import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager_1_1 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Initialize connection (e.g., using DriverManager.getConnection())
            // For demonstration purposes, assume conn is initialized

            // Start transaction
            conn.setAutoCommit(false);
            // Perform some operations
            // Commit transaction
            conn.commit();
        } catch (SQLException e) {
            // Rollback transaction on error
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error rolling back transaction: " + ex.getMessage());
                }
            }
        } finally {
            // Release resources
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Error closing connection: " + ex.getMessage());
                }
            }
        }
    }
}