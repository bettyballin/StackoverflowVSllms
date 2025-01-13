import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCallableStatementInvoker {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a CallableStatement object
            CallableStatement cs = connection.prepareCall("CALL testEM(?)");

            // Set the input parameter
            cs.setString(1, "your_input_value");

            // Execute the stored procedure
            cs.execute();

            // Close the CallableStatement and Connection objects
            cs.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error executing stored procedure: " + e.getMessage());
        }
    }
}