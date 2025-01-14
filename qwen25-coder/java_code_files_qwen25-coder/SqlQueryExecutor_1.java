import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlQueryExecutor_1 {
    public static void main(String[] args) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        String username = null;  // Initialize with actual username
        String password = null;  // Initialize with actual password
        Connection connection = null;  // Obtain your database connection here

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            // Process the result set...
        } catch (SQLException e) {
            // Handle possible SQL exceptions
            e.printStackTrace();
        }
    }
}