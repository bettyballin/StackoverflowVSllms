import oracle.jdbc.OracleConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionTest_1 {

    public static void main(String[] args) {
        // Specify your Oracle database connection details here
        String dbUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String username = "your_username";
        String password = "your_password";

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);

            OracleConnection oraConn = (OracleConnection) conn;
            if (!oraConn.pingDatabase()) {
                System.out.println("Connection is likely closed or invalid");
            } else {
                System.out.println("Connection is valid");
            }

            // Close the connection when done
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}