import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSessionChecker {
    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE TIMESTAMPDIFF(MINUTE, login_time, NOW()) <= ?";

        // Assuming you have a MySQL database with a 'users' table
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, 10);
            try (ResultSet results = pstmt.executeQuery()) {
                // Process the results
                while (results.next()) {
                    // Do something with the results
                    System.out.println(results.getString(1));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}