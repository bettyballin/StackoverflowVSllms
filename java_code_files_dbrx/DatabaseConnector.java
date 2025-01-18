import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost/mydb";
        String user = "username";
        String password = "password";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // use the same 'connection' for multiple queries here...
        } catch (SQLException e) {
            System.out.println("Could not connect to: " + url);
        }
    }
}