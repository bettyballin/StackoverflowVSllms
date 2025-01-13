import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_25 {
    public static String sanitize(String input) {
        input = input.trim();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT ?");
            pstmt.setString(1, input);
            return pstmt.toString().replace("SELECT ", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, World!"));
    }
}