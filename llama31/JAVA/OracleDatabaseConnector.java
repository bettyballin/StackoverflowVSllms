import java.sql.Connection;
import org.apache.commons.dbcp2.BasicDataSource;

public class OracleDatabaseConnector {
    public static void main(String[] args) throws Exception {
        // Create a connection pool
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:oracle:thin:@//localhost:1521/ORCL");
        ds.setUsername("username");
        ds.setPassword("password");
        ds.setInitialSize(5);
        ds.setMaxTotal(10); // corrected method name from setMaxActive to setMaxTotal

        // Get a connection from the pool
        Connection conn = ds.getConnection();

        // Use the connection
        // ...

        // Close the connection
        conn.close();
    }
}