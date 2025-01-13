import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO_9_9 {
    public static void main(String[] args) {
        // Create a connection object (dummy for demonstration purposes)
        Connection connection = null;
        try {
            // Assume a JDBC connection is established
            connection = DriverManager.getConnection("url", "user", "password");

            // Create a prepared statement
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE name = ?");
            String userInput = "JohnDoe"; // dummy user input
            pstmt.setString(1, userInput);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}