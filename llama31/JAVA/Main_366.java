import oracle.jdbc.OracleConnection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_366 {
    public static void main(String[] args) {
        try {
            // Get the OracleConnection object
            OracleConnection conn = (OracleConnection) DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

            // Set the application information
            conn.setClientInfo("OCSID.CLIENT_INFO", "my program");
            conn.setClientInfo("OCSID.MODULE", "something");

            // Verify the application information
            System.out.println(conn.getClientInfo("OCSID.CLIENT_INFO"));  // prints "my program"
            System.out.println(conn.getClientInfo("OCSID.MODULE"));  // prints "something"
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}