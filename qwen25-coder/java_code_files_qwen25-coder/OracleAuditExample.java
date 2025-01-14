import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleAuditExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM DBA_AUDIT_TRAIL WHERE ACTION = 'INSERT'")) {

            while (rs.next()) {
                System.out.println("Transaction detected: " + rs.getString("SQL_TEXT"));
                // React to transactions as needed
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}