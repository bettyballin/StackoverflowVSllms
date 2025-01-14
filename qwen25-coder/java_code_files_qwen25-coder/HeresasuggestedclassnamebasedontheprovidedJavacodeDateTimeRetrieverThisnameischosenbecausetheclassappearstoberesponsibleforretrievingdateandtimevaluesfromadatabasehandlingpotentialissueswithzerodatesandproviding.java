import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateTimeRetriever {
    public static void main(String[] args) {
        // Configure your JDBC URL to allow zero dates
        String jdbcUrl = "jdbc:mysql://your_host/your_database?allowPublicKeyRetrieval=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
    
        try (Connection conn = DriverManager.getConnection(jdbcUrl, "username", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT add_date FROM your_table")) {
    
            while (rs.next()) {
                String dateTimeString = rs.getString("add_date");
                // Handle the null or valid date string as needed
                System.out.println(dateTimeString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}