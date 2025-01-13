import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryExecutor_4_4 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_database"; // replace with your database URL
        String username = "my_username"; // replace with your database username
        String password = "my_password"; // replace with your database password

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            // Execute a long-running query
            stmt.executeQuery("SELECT * FROM my_table");

            // To cancel the query
            stmt.cancel();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while executing query: " + e.getMessage());
        }
    }
}