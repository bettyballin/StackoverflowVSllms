import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class OracleDatabaseConnector_2_2 {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("oracle.jdbc.date_format", "YYYY-MM-DD HH24:MI:SS");
        props.put("user", "your_username");
        props.put("password", "your_password");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", props);
    }
}