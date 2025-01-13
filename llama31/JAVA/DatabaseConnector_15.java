import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnector_15_15 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("your_url", "your_username", "your_password");
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("your_query");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}