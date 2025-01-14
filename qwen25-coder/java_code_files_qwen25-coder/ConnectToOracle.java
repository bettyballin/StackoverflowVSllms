import java.lang.String;
// Example of connecting to an Oracle database programmatically using JDBC (not relevant to DBeaver setup but useful)
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToOracle {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port:SID", "username", "password");
            System.out.println("Connected to Oracle database successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}