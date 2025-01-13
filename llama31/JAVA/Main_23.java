import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_23 {
    public static String sanitize(String input) {
        input = input.trim();
        try (Connection conn = DriverManager.getConnection("your_database_url", "your_username", "your_password")) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT ?");
            pstmt.setString(1, input);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(1);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, World!"));
    }
}