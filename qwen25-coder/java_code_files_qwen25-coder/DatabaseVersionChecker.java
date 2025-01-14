import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseVersionChecker {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@host:port:sid", "user", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM v$version")) {

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}