import java.sql.*;

public class StoredProcedureExecutor {
    public static void main(String[] args) {
        // Connect to the database... (not included)
        Connection conn = null; // Placeholder for the database connection

        String id = "example_id"; // Or get the value from somewhere else
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("CALL testEM(?)");
            cstmt.setString(1, id);

            // Execute and process results... (not included)
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (cstmt != null) {
                try {
                    if (!cstmt.isClosed()) {
                        cstmt.close();
                    }
                } catch (SQLException e) {
                    System.err.println("Error closing statement: " + e.getMessage());
                }
            }
        }
    }
}