import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsernameChecker {
    public static void main(String[] args) {
        // Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        String userToCheck = "username_to_check";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");
            stmt.setString(1, userToCheck);
            ResultSet result = stmt.executeQuery();
            if (result.next() && result.getInt(1) > 0) {
                System.out.println("Username exists");
            } else {
                System.out.println("Username does not exist");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}