import java.sql.*;

public class PreparedStatementHelper {
    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE id = ?";

        Connection connection = null; // Initialize your connection here
        int userId = 1; // Set your userId here

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                // Process result set...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}