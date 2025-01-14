import java.sql.*;

public class PatternMatcher {
    // Example in Java with JDBC
    public static void main(String[] args) {
        String query = "SELECT * FROM your_table WHERE field LIKE ? OR field LIKE ? OR field LIKE ? OR field = ?";

        String targetNumber = "someNumber"; // Initialize targetNumber
        try (Connection connection = DriverManager.getConnection("jdbc:yourdb", "username", "password");
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            String likePattern1 = "%," + targetNumber + ",%";
            String likePattern2 = targetNumber + ",%";
            String likePattern3 = "%," + targetNumber;
            pstmt.setString(1, likePattern1);
            pstmt.setString(2, likePattern2);
            pstmt.setString(3, likePattern3);
            pstmt.setString(4, targetNumber);
            ResultSet rs = pstmt.executeQuery();
            // Process the result set

        } catch (SQLException e) {
            // Handle exception
        }
    }
}