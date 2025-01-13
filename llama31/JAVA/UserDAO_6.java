import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO_6_6 {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
        String username = "your_username";
        pstmt.setString(1, username);
        ResultSet results = pstmt.executeQuery();
        while (results.next()) {
            System.out.println(results.getString(1));
        }
        pstmt.close();
        connection.close();
    }
}