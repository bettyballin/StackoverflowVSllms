import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector_2 {
    public static void main(String[] args) {
        // Fetching DB credentials from environment variables
        String dbUrl = "jdbc:yourdatabase://hostname:port/yourdatabase";
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}