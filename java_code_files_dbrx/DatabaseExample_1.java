import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseExample {
    public static void main(String[] args) throws Exception {
        Class.forName("com.gemstone.gemfire.sql.GemFireDataSource");
        String url = "jdbc:gemfire://localhost/your_gemstone_db";
        Properties properties = new Properties();
        // Set properties as needed
        Connection conn = DriverManager.getConnection(url, properties);
        Statement stmt = conn.createStatement();
        // Perform your database operations
        // ...

        // Clean up resources
        stmt.close();
        conn.close();
    }
}