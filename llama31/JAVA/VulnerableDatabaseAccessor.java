import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VulnerableDatabaseAccessor {
    // Note: This code demonstrates a SQL injection vulnerability.
    // It should not be used in production or any environment where security is a concern.

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace with your database URL
        String dbUsername = "your_username"; // Replace with your database username
        String dbPassword = "your_password"; // Replace with your database password
        String username = "example_username"; // Example username for query
        String password = "example_password"; // Example password for query

        try {
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                System.out.println("User found");
                // Handle result set as needed
            }

            results.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while accessing the database:");
            e.printStackTrace();
        }
    }
}