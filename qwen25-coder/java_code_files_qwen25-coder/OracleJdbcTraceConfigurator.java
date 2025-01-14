import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJdbcTraceConfigurator {
    public static void main(String[] args) {
        // Enable all levels of tracing
        System.setProperty("oracle.jdbc.Trace", "true");
        
        // Or, if you want more control and enable specific types of tracing:
        // java.util.logging.Logger oracleLog = java.util.logging.Logger.getLogger("oracle.jdbc.driver.OracleDriver");
        // oracleLog.setLevel(java.util.logging.Level.FINE);
        
        String url = "your_database_url_here";
        String user = "your_username";
        String password = "your_password";

        try {
            // Your JDBC connection code here
            Connection conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}