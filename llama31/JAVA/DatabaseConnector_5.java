import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector_5_5 {
    public static void main(String[] args) {
        String jdbcUrl = "your_jdbc_url"; // replace with your JDBC URL
        String username = "your_username"; // replace with your username
        String password = "your_password"; // replace with your password

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            conn.setSchema("SCOTT");
            // You may want to close the connection after use to avoid resource leak
            // conn.close();
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}