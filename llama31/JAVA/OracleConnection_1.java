import oracle.jdbc.OracleDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class OracleConnection_1 {
    public static void main(String[] args) throws Exception {
        OracleDriver driver = new OracleDriver();
        DriverManager.registerDriver(driver);
        
        Properties props = new Properties();
        // Add your connection properties here, e.g.
        // props.setProperty("user", "your_username");
        // props.setProperty("password", "your_password");
        
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", props);
        
        // Use the connection
        // ...
    }
}