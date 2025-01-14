import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecurePreparedStatementExample {
    // Example in Java using PreparedStatement for SQL queries to avoid SQL Injection
    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE username=?";
        Connection connection = null; // Initialize your connection here
        String userInput = ""; // Get user input here

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, userInput);
            ResultSet rs = pstmt.executeQuery();
            // Process the result set
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}