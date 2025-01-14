import java.lang.String;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnectionCheck {
    public static boolean isConnectionOpen(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT SYSDATE FROM DUAL")) {
            return true; // If we reach here, the connection is open.
        } catch (SQLException e) {
            return false; // If an exception occurs, the connection is likely closed.
        }
    }

    public static void main(String[] args) {
        // Assume 'conn' is your JDBC Connection object
        Connection conn = null; // This should be your actual connection object

        if (isConnectionOpen(conn)) {
            System.out.println("The connection is open.");
        } else {
            System.out.println("The connection is closed.");
        }
    }
}