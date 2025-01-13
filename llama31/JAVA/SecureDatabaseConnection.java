import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SecureDatabaseConnection {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        try (Connection conn = DriverManager.getConnection(dbUrl, props)) {
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}