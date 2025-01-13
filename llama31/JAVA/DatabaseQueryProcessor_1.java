import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryProcessor_1_1 {
    public static void main(String[] args) {
        // Create a connection to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("url", "user", "password");
            // Create a single Statement object
            Statement stmt = conn.createStatement();

            // Execute the first query and store the ResultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM table1");

            // Process the first ResultSet
            while (rs.next()) {
                // Do something with the data from the first ResultSet

                // If needed, execute the second query and store the ResultSet
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM table2");

                // Process the second ResultSet
                while (rs2.next()) {
                    // Do something with the data from the second ResultSet
                }

                // Close the second ResultSet
                rs2.close();
            }

            // Close the first ResultSet and the Statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while executing queries: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error occurred while closing connection: " + e.getMessage());
                }
            }
        }
    }
}