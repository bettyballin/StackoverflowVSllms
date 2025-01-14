import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecureLoginQueryManager {
    String query = "SELECT * FROM users WHERE username=? AND password=?";

    public static void main(String[] args) {
        // Placeholder for database connection
        Connection connection = null; // Should be properly initialized

        // Placeholder for user input
        String userInputUsername = "username";
        String userInputPassword = "password";

        SecureLoginQueryManager manager = new SecureLoginQueryManager();

        try (PreparedStatement pstmt = connection.prepareStatement(manager.query)) {
            pstmt.setString(1, userInputUsername);
            pstmt.setString(2, userInputPassword);
            ResultSet rs  = pstmt.executeQuery();
            // process result
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}