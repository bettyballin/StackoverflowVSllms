import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a PreparedStatement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE first_name = ?");
            stmt.setString(1, "John");

            // Execute the query
            ResultSet results = stmt.executeQuery();

            // Process the results
            while (results.next()) {
                System.out.println(results.getString("first_name") + " " + results.getString("last_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the connection
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