import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryExecutor_3 {
    public static void main(String[] args) {
        // Example SQL Query (same for both databases)
        String sqlQuery = "SELECT * FROM Questions WHERE Tags LIKE '%java%' LIMIT 10;";
        
        // MySQL connection
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery)) {
            while (rs.next()) {
                // Process results
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // MS SQL connection (using SQL Server JDBC driver)
        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=mydatabase;user=user;password=password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery)) {
            while (rs.next()) {
                // Process results
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}