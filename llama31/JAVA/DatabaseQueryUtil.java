import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class DatabaseQueryUtil {
    public static void main(String[] args) {
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // Create a collection of strings
            String[] collectionOfStrings = {"string1", "string2", "string3"};

            // Prepare the SQL statement
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE id IN (?)");

            // Set the array parameter
            stmt.setArray(1, conn.createArrayOf("VARCHAR", collectionOfStrings));

            // Execute the query
            stmt.execute();

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}