import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class OracleDatabaseConnector_1_1 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("oracle.jdbc.defaultNChar", "true");
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", props);
            // You may want to do something with the connection here...
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}