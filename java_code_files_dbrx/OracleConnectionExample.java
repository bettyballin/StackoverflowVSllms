import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionExample {
    // Example of how to connect using Java:
    String url = "jdbc:oracle://localhost"; // Replace with your Oracle URL
    String username = "your_username"; // Use a limited access user
    String password = "your_secret_password"; // Secure the password appropriately
    Connection conn;

    public OracleConnectionExample() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        try {
            OracleConnectionExample example = new OracleConnectionExample();
            // Add your code to use the connection here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}