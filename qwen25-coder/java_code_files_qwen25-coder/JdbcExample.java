import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcExample {
    // Example using JDBC in Java
    
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("url", "user", "password")) {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            long userId = 1; // Assuming userId is defined
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            // process result
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}