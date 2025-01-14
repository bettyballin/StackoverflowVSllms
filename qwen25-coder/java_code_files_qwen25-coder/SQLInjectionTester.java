import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLInjectionTester {
    // Example of a simple method to verify injection vulnerability in web applications

    private Connection connection; // Declare the 'connection' variable

    public void testForSQLInjection(String userInput) {
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        // Instead, use parameterized queries to prevent SQL Injection
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?")) {
            preparedStatement.setString(1, userInput);
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    }
}