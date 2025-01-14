import java.sql.*;

public class Example_24 {
    public static void main(String[] args) throws SQLException {
        String login = "user_login";
        String password = "user_password";

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbname", "username", "password");
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE login=? AND pass=?");
        pstmt.setString(1, login);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
    }
}