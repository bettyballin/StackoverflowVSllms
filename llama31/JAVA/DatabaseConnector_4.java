import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector_4_4 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:sqlite:./test.db"; // replace with your database URL
        try (Connection conn = DriverManager.getConnection(dbUrl);
             Statement stmt = conn.createStatement()) {
            // use the statement
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}