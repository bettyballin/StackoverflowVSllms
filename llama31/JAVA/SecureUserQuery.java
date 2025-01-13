import java.sql.*;

public class SecureUserQuery {
    public static void main(String[] args) {
        // Example of a secure prepared statement in Java
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection("your_database_url", "your_database_username", "your_database_password");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet results = pstmt.executeQuery();

            while (results.next()) {
                // Process the results
                System.out.println(results.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}