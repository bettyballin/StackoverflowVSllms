import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQueryExecutor_16_16 {
    public static void main(String[] args) {
        // Insecure example
        String username = "JohnDoe"; // Example username
        String query = "SELECT * FROM employees WHERE name = '" + username + "'";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Secure example
        query = "SELECT * FROM employees WHERE name = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}