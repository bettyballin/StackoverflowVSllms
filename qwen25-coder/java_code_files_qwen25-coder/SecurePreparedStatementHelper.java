import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecurePreparedStatementHelper {

    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

    public void executeQuery() {
        Connection connection = null; // Assuming connection has been established
        String username = "yourUsername"; // Replace with actual username
        String password = "yourPassword"; // Replace with actual password

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            // process result set
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecurePreparedStatementHelper helper = new SecurePreparedStatementHelper();
        helper.executeQuery();
    }
}