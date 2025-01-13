import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInserter_3_3 {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a prepared statement
            PreparedStatement statement = connection.prepareStatement("insert into test(myNum) values(?)", Statement.RETURN_GENERATED_KEYS);

            // Set the value for the prepared statement
            statement.setInt(1, 555);

            // Execute the update
            statement.executeUpdate();

            // Get the generated keys
            ResultSet generatedKeys = statement.getGeneratedKeys();

            // Check if there are any generated keys
            if (generatedKeys.next()) {
                // Get the generated ID
                int generatedId = generatedKeys.getInt(1);
                System.out.println("Generated ID: " + generatedId);
            }

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        }
    }
}