import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO_16_16 {
    public static void main(String[] args) {
        // Create a connection to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");

            // Create a prepared statement
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE name = ?");

            // Set the parameter value
            pstmt.setString(1, "John");

            // Execute the statement
            ResultSet results = pstmt.executeQuery();

            // Process the results
            while (results.next()) {
                // Process each row
                System.out.println(results.getString(1)); // Assuming the first column is the name
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close the connection: " + e.getMessage());
                }
            }
        }
    }
}