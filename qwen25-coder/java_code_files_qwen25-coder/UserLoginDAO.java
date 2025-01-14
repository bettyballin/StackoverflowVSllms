import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDAO {

    String url = "jdbc:your_database_url";
    String user = "your_database_user";
    String password = "your_database_password";

    public void login(String userInputUsername, String userInputPassword) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userInputUsername);
            pstmt.setString(2, userInputPassword);

            ResultSet rs = pstmt.executeQuery();
            // Process the result set...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}