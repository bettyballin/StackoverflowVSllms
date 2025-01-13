import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionTest {
    public static void main(String[] args) {
        String dbUrl = "jdbc:oracle:thin:@//<hostname>:<port>/<SID>";
        String username = "<username>";
        String password = "<password>";

        try {
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connected to Oracle database!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to Oracle database: " + e.getMessage());
        }
    }
}