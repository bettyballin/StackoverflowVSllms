import oracle.jdbc.driver.OracleLog;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main_760 {
    public static void main(String[] args) {
        try {
            // Enable logging
            System.setProperty("oracle.jdbc.Trace", "true");

            // Configure logging properties
            OracleLog.setLogFileName("oracle_jdbc.log");
            OracleLog.setLogLevel(OracleLog.LOG_LEVEL_ALL);

            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Create a connection
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
            System.out.println("Connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred during connection.");
            e.printStackTrace();
        }
    }
}