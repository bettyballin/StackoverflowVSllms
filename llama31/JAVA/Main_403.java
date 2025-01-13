import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_403 {
    public static void main(String[] args) {
        String connectionString = "jdbc:sqlserver://localhost";
        String username = "your_username";
        String password = "your_password";

        try {
            Connection connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("Connected to the database successfully!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}