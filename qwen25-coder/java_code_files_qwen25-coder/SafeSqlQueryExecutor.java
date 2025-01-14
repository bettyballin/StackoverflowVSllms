import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SafeSqlQueryExecutor {
    public static void main(String[] args) {
        // Example in Java using JDBC with SQLite
        String userInput = "x"; // This is what you want to search for
        String sql = "SELECT * FROM table WHERE title LIKE ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + userInput + "%"); // Concatenate wildcards and set parameter

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Process result set
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}