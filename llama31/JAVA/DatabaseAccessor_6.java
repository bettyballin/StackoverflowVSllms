import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccessor_6_6 {
    public static void main(String[] args) {
        // Assuming you're using MySQL
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM table_name LIMIT 1000 OFFSET 0";
            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                // Process the result set
                while (rs.next()) {
                    // Process each row
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}