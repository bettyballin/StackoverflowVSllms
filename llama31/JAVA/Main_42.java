import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_42 {
    public static void main(String[] args) {
        // Define the database connection parameters
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        // Define the SQL query
        String query = "SELECT fname, lname FROM people WHERE isValid = 1 AND lname LIKE '%test%'";

        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
            return;
        }

        // Establish a connection to the database
        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            // Create a Statement object to execute the query
            try (Statement stmt = conn.createStatement()) {
                // Execute the query and store the results in a ResultSet
                try (ResultSet rs = stmt.executeQuery(query)) {
                    // Iterate over the results and print the fname and lname columns
                    while (rs.next()) {
                        System.out.println(rs.getString("fname") + " " + rs.getString("lname"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}