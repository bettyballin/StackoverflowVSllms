import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyClass {
    public static void main(String[] args) {
        try (Connection conn = getMyDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM my_table WHERE some_col = ?")) {
            stmt.setString(1, "my_criteria");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // process single row here
                }
            }
        } catch (SQLException ex) {
            handleException(ex);
        }
    }

    private static Connection getMyDatabaseConnection() throws SQLException {
        // Implement database connection retrieval
        return null;
    }

    private static void handleException(SQLException ex) {
        // Implement exception handling
    }
}