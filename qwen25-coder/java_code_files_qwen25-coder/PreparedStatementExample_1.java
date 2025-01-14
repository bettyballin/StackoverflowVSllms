import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample_1 {
    public static void main(String[] args) {
        // Example in Java using JDBC PreparedStatement
        String sql = "SELECT * FROM users WHERE username = ?";
        Connection connection = null; // Initialize or obtain your database connection here
        String username = "exampleUsername"; // Obtain the username value appropriately

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            // process result set
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}