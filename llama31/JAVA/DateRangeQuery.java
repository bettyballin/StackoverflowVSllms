import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DateRangeQuery {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            Date givenDate = new Date(System.currentTimeMillis()); // Replace with the desired date

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM group_table WHERE ? BETWEEN ArrivalDate AND DepartureDate");
            stmt.setDate(1, givenDate);
            ResultSet results = stmt.executeQuery();

            // Process the results
            while (results.next()) {
                // Print or process the results
                System.out.println(results.getString(1));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading database driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}