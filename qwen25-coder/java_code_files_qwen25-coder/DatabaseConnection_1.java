import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDatabaseException;

public class DatabaseConnection_1 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@host:port:sid";
        String user = "yourUser";
        String password = "yourPassword";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database...");
        } catch (SQLException e) {
            if (e instanceof OracleDatabaseException) {
                OracleDatabaseException oe = (OracleDatabaseException) e;
                int errorCode = oe.getOracleError();
                System.out.println("Caught Oracle exception: " + errorCode);
                // Handle specific error codes here
            }
        }
    }
}