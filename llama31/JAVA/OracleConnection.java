import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnection {
    public static void main(String[] args) throws Exception {
        // Set the compatibility mode to "10g" (e.g., for Oracle 10g databases)
        System.setProperty("oracle.jdbc.driver.OracleDriver.compatibility", "10g");

        // Load the Oracle JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Establish a connection
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
    }
}