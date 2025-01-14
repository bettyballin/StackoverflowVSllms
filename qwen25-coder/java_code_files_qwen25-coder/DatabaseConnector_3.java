import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector_3 {
    public static void main(String[] args) {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}