import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_17 {
    public static String sanitize(String input) {
        input = input.trim();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password")) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT ?");
            pstmt.setString(1, input);
            input = pstmt.toString().replaceFirst(".*\\(.*\\)", "");
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("  test  "));
    }
}