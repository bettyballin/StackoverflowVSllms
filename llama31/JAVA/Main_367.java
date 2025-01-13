import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_367 {
    public static void main(String[] args) {
        // Replace with your database URL, username, and password
        String url = "jdbc:postgresql://localhost:5432/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(g.id) FROM \"Group\" g")) {

            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}