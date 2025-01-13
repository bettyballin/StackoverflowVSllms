import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExecutor {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the JDBC driver and establish a connection to the database
            conn = DriverManager.getConnection("jdbc:your_database_url", "your_username", "your_password");

            String query = "SELECT * FROM your_table WHERE industry = ?";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, 7); // Note: setParameter is not a valid method, use setInt instead
                try (ResultSet rs = ps.executeQuery()) {
                    // process the result set
                    while (rs.next()) {
                        // Process each row of the result set
                        System.out.println(rs.getString(1));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}