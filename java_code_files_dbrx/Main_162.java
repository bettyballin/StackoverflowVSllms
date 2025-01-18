// Using PreparedStatement or ParameterizedQueries for preventing SQL Injection
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String query = "SELECT password_hash FROM users WHERE username=?";
        Connection conn = null; // Placeholder for the database connection
        String username = "exampleUser"; // Placeholder username

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, username); // Binding the parameter to prevent SQL injection attacks
    }
}