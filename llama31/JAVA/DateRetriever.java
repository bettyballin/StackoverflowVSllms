import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;

public class DateRetriever {
    public static void main(String[] args) {
        // Database connection settings
        String dbUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String dbUser = "myuser";
        String dbPassword = "mypassword";

        // Create a connection to the database
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {

            // Retrieve the date from MySQL
            ResultSet rs = stmt.executeQuery("SELECT date FROM mytable");
            while (rs.next()) {
                Date sqlDate = rs.getDate("date");
                LocalDate date = sqlDate.toLocalDate();
                // Use the LocalDate object
                System.out.println(date);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}