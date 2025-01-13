import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SequenceFetcher_1_1 {
    public static void main(String[] args) {
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

            // Create a CallableStatement
            CallableStatement cs = conn.prepareCall("BEGIN fetch_ids(?, ?, ?); END;");

            // Set the parameters
            cs.setString(1, "my_sequence");
            cs.setInt(2, 100);
            cs.setInt(3, 50); // dynamic increment size

            // Execute the stored procedure
            cs.execute();

            // Close the connection
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading database driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error connecting to database or executing stored procedure: " + e.getMessage());
        }
    }
}