import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO_17_17 {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a PreparedStatement object
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?");

            // Set the parameter for the PreparedStatement
            stmt.setString(1, "admin");

            // Execute the query and store the results
            ResultSet results = stmt.executeQuery();

            // Process the results
            while (results.next()) {
                System.out.println(results.getString("name"));
            }

            // Close the resources
            results.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}