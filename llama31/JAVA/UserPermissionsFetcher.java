import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserPermissionsFetcher {
    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Assuming MySQL database
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
            return;
        }

        // Establish a database connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
        } catch (Exception e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
            return;
        }

        int userId = 1; // Replace with the actual user ID

        try (PreparedStatement pstmt = connection.prepareStatement("SELECT permissions FROM acl WHERE user_id = ?")) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("permissions"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}