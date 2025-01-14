import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector_5 {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            System.out.println("Connected to the Oracle Database!");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}