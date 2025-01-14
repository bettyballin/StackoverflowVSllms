import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementExecutor {
    public static void main(String[] args) {
        String sql = "{call GetUserDetails(?)}";
        String url = "jdbc:yourdatabaseurl";
        String user = "yourusername";
        String password = "yourpassword";
        int userId = 1; // Assuming userId is an integer parameter

        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Process result set...
            }
        } catch (SQLException e) {
            // Handle exception...
            e.printStackTrace();
        }
    }
}