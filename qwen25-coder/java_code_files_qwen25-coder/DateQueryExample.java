import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class DateQueryExample {
    public static void main(String[] args) {
        String url = "jdbc:yourDatabaseUrl"; // Replace with your database URL
        String user = "yourUsername";         // Replace with your database username
        String password = "yourPassword";     // Replace with your database password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Date targetDate = Date.valueOf("2009-09-09");
            
            String query = "SELECT * FROM foo WHERE date_column = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setDate(1, targetDate);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        // Process your result set here
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}