import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleJdbcExample {
    public static void main(String[] args) {
        // Example of setting charset in a JDBC URL for Oracle
        String url = "jdbc:oracle:thin:@hostname:port:sid";
        Properties props = new Properties();
        props.put("user", "username");
        props.put("password", "password");
        props.put("oracle.jdbc.defaultNChar", "true"); // Use national character set

        // For specifying the charset directly in URL
        String urlWithCharset = "jdbc:oracle:thin:@hostname:port:sid?useUnicode=true&characterEncoding=ISO-8859-5";

        try (Connection conn = DriverManager.getConnection(url, props)) {
            // Your database operations here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}