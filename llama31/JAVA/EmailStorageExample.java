import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmailStorageExample {
    public static void main(String[] args) {
        String email = "example@example.com";

        // Establish a database connection
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
            // Create a prepared statement
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (email) VALUES (?)")) {
                // Set the email address
                pstmt.setString(1, email);

                // Execute the query
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}