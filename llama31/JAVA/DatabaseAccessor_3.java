import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAccessor_3_3 {
    public static void main(String[] args) {
        String query = "SELECT * FROM table WHERE id = ?";
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 7);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}