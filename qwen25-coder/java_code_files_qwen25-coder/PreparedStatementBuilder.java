import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementBuilder {
    String sql = "SELECT * FROM users WHERE username=?";

    public void executeQuery(Connection connection, String userInput) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, userInput);
            ResultSet rs = stmt.executeQuery();
            // Process the ResultSet if needed
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Connection connection = ...
        // String userInput = "exampleUser";
        // new PreparedStatementBuilder().executeQuery(connection, userInput);
    }
}