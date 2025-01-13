import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_326 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("url", "user", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("query")) {
            // process the result set
            while (rs.next()) {
                // process each row
            }
        } catch (SQLException e) {
            // handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}