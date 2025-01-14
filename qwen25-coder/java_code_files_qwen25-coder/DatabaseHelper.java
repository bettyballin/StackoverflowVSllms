import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourDatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void executeNonQuery(String sql, Object... params) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            // Handle possible SQL exceptions
            throw new SQLException("Database error", e);
        }
    }

    public static void main(String[] args) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        try {
            executeNonQuery(query, "John Doe", "john.doe@example.com");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}