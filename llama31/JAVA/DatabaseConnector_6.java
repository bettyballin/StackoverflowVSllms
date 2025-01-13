import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector_6_6 {
    String dbUrl = "jdbc:mysql://localhost:3307/mydatabase";
    String username = "your_username"; // replace with your actual username
    String password = "your_password"; // replace with your actual password

    public static void main(String[] args) {
        DatabaseConnector_6 connector = new DatabaseConnector_6();
        connector.connect();
    }

    public void connect() {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connected to the database");
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}