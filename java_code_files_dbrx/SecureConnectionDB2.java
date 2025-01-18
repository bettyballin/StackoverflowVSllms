import java.lang.String;
import java.sql.*;
import java.util.Properties;

public class SecureConnectionDB2 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:db2://localhost:50000/sample";
        Properties properties = new Properties();
        properties.setProperty("user", "user");
        properties.setProperty("password", "pass");
        properties.setProperty("sslConnection", "true"); // Enables SSL encryption for the connection
        Connection con = DriverManager.getConnection(url, properties);
    }
}