import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Sanitizer_11 {
    public static String sanitize(String input) {
        input = input.trim();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT ?");
            pstmt.setString(1, input);
            return pstmt.toString().split(":")[1].trim();
        } catch (SQLException e) {
            // handle SQL exception
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(sanitize("input"));
    }
}