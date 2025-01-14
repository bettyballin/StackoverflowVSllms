import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlExecutor {
    // Java code for direct SQL execution

    public static void main(String[] args) {
        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
        Connection connection = null; // Placeholder for actual database connection
        String username = "your_username"; // Placeholder for actual username
        String email = "your_email@example.com"; // Placeholder for actual email

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}