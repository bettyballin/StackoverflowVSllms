import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleSecureConnection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String username = "your_username";
        String password = "your_password";

        // Enable SSL/TLS encryption
        Properties props = new Properties();
        props.setProperty("javax.net.ssl.trustStore", "/path/to/truststore.jks");
        props.setProperty("javax.net.ssl.trustStorePassword", "truststore_password");

        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println("Connected to Oracle DB securely!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}