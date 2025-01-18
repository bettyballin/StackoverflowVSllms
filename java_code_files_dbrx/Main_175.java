import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");

        Properties properties = new Properties(); // create a Properties object to set the parameters
        properties.put("user", "TESTUSER"/*your database user*/);
        properties.put("password", "TESTPASSWORD"/*database password*/);
        properties.setProperty("oracle.jdbc.defaultRowPrefetch", "10");  // setting the row prefetch size in JDBC driver

        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // define the 'url' variable
        connection = DriverManager.getConnection(url, properties); // using Properties object to connect to database
    }
}