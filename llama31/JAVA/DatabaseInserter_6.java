import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInserter_6_6 {
    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load database driver");
            return;
        }

        // Create a connection to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("your_database_url", "your_database_username", "your_database_password");
        } catch (SQLException e) {
            System.out.println("Could not connect to database");
            return;
        }

        // Create a prepared statement
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO my_table (id, name) VALUES (my_sequence.NEXTVAL, ?)", 
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, "John Doe");
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong(1);
                // use the generated id
                System.out.println("Generated id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL statement");
        } finally {
            // Close the statement and connection
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connection");
            }
        }
    }
}