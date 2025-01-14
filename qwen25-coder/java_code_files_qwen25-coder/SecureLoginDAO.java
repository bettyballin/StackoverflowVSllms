import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecureLoginDAO {
    String sql = "SELECT * FROM users WHERE username=? and password=?";
    Connection connection;
    String username;
    String password;

    public SecureLoginDAO() {
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
    }

    public static void main(String[] args) {
    }
}