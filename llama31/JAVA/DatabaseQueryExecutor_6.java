import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExecutor_6_6 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a query
            String query = "SELECT * FROM t1 WHERE MATCH (t1.foo_desc, t2.bar_desc) AGAINST (? IN BOOLEAN MODE)";

            // Prepare the statement
            PreparedStatement stmt = connection.prepareStatement(query);

            // Set the parameter
            stmt.setString(1, "+foo* +bar*");

            // Execute the query
            ResultSet results = stmt.executeQuery();

            // Process the results
            while (results.next()) {
                // Handle the results here
                System.out.println(results.getString(1)); // Replace with your actual column index
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Error accessing the database: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing the connection: " + e.getMessage());
            }
        }
    }
}