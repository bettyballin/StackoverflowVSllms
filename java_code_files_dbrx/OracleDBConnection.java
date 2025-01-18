import java.sql.Connection;
import java.sql.DriverManager;

public class OracleDBConnection {

    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver"); // Load Oracle driver
        String url = "jdbc:oracle:oci:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=tcp)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=YOURDB)))";    // Update this based on your tnsnames.ora entries
        String username = "your_username"; // Replace with your username
        String password = "your_password"; // Replace with your password
        Connection connection = DriverManager.getConnection(url, username, password);  // Connect using driver and specified URL

        // Do something with the connection
        System.out.println("Connection established.");

        // Close connection
        connection.close();
    }
}