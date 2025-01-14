import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//foo1.com:1530/FOO";
        String user = "your_username"; // replace with your username
        String password = "your_password"; // replace with your password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}