import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExecutor_14_14 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database"; // replace with your database URL
        String username = "your_username"; // replace with your database username
        String password = "your_password"; // replace with your database password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Using standardized SQL syntax
            String query = "SELECT * FROM customers WHERE country='USA'";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet results = stmt.executeQuery()) {
                    while (results.next()) {
                        System.out.println(results.getString(1)); // example: print the first column
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}