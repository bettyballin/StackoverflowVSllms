import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseQueryExecutor_18_18 {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a prepared statement
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM your_table WHERE custid = ?");

            // Set the parameter
            pstmt.setInt(1, 123); // assuming custid is an integer

            // Execute the query
            ResultSet results = pstmt.executeQuery();

            // Process the results
            while (results.next()) {
                // Do something with the results
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}