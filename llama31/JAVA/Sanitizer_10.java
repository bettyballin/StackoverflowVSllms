import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sanitizer_10 {

    public static String sanitize(String input) {
        input = input.trim();

        // Note: Java does not have a direct equivalent to mysql_real_escape_string
        // This is a simplified example using JDBC's Connection.prepareStatement
        // with a placeholder for the input parameter to prevent SQL injection.
        try (Connection conn = DriverManager.getConnection("your_database_url", "your_username", "your_password")) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT ?");
            pstmt.setString(1, input);
            return pstmt.toString();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(sanitize("   Hello, World!   "));
    }
}