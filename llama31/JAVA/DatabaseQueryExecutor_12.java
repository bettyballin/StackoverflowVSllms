import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryExecutor_12_12 {
    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
            return;
        }

        // Establish a connection to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "my_user", "my_password");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return;
        }

        // Create a statement
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error creating statement: " + e.getMessage());
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
            return;
        }

        // Create a cursor
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM my_table");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing statement or connection: " + ex.getMessage());
            }
            return;
        }

        // Process each row individually
        try {
            while (rs.next()) {
                // Process the current row
            }
        } catch (SQLException e) {
            System.out.println("Error processing results: " + e.getMessage());
        } finally {
            // Close the result set and statement
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing result set, statement, or connection: " + e.getMessage());
            }
        }
    }
}