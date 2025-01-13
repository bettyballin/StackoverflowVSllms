import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAccessor_2_2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your database URL
        String username = "myuser"; // replace with your database username
        String password = "mypassword"; // replace with your database password
        String query = "SELECT * FROM mytable WHERE industry = ?"; // replace with your SQL query

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 7); // set the parameter
            // execute the query
            ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        }
    }
}