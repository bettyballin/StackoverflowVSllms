import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_7 {
    public static String sanitize(String input) {
        return input.trim();
    }

    public static void main(String[] args) {
        String input = "example input";
        String sanitizedInput = sanitize(input);

        // Example usage with PreparedStatement
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String dbUser = "myuser";
        String dbPassword = "mypassword";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM mytable WHERE mycolumn = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sanitizedInput);

            // Execute the query
            pstmt.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}