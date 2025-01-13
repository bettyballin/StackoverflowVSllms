import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class OracleDatabaseConnector_3_3 {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("oracle.jdbc.date_time_literals", "TIMESTAMP");
        Connection conn = DriverManager.getConnection("your_url", props);
    }
}