import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOptionLoader {
    public static void main(String[] args) {
        // Assuming a JDBC connection to the database
        String dbUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM options")) {

            while (rs.next()) {
                String name = rs.getString("name");
                String value = rs.getString("value");
                // Process the option
                System.out.println("Name: " + name + ", Value: " + value);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}