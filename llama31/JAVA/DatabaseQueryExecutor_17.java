import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExecutor_17_17 {
    public static void main(String[] args) {
        // Establish a database connection
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password)) {
            // Create a prepared statement
            PreparedStatement stmt = connection.prepareStatement(
                "SELECT a, b, c, MAX(n) as max_n " +
                "FROM your_table " +
                "GROUP BY a, b, c"
            );

            // Execute the query and store the result
            ResultSet rs = stmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("a") + ", " + rs.getString("b") + ", " + rs.getString("c") + ", " + rs.getInt("max_n"));
            }
        } catch (SQLException e) {
            System.err.println("Error executing database query: " + e.getMessage());
        }
    }
}