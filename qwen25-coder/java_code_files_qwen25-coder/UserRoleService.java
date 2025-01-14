import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRoleService {
    public void assignRoleToUser(String username, String role) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:yourdb", "app_user", "StrongPassword123");
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO user_roles (username, role_name) VALUES (?, ?)")) {
            stmt.setString(1, username);
            stmt.setString(2, role);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
    }
}