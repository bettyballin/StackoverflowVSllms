import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleProxyConnection;

public class Main_705 {
    public static void main(String[] args) {
        try {
            // Create a connection to the database as the proxy user
            Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/ORCL", 
                "proxy_user", "proxy_password");

            // Create a proxy connection for the real user
            OracleProxyConnection proxyConn = (OracleProxyConnection) ((OracleConnection) conn).proxySession(
                "real_user", "real_user_password");

            // Use the proxy connection to execute SQL statements
            Statement stmt = proxyConn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM my_table");

            // Close the result set, statement, and connection to prevent resource leaks
            rset.close();
            stmt.close();
            proxyConn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}