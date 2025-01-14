import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;

public class SetApplicationInfo {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//your_host:port/service_name";
        String user = "your_user";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            OracleConnection oracleConn = (OracleConnection) conn;
            
            // Set Module Name
            oracleConn.setClientInfo("oracle.jdbc.driver.OracleConnection.moduleName", "something");
            
            // Set Action Name (Command)
            oracleConn.setClientInfo("oracle.jdbc.driver.OracleConnection.actionName", "UNKNOWN");

            System.out.println("Module and Action set successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}