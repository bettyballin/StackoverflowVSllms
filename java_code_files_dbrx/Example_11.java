import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class Example {
    public static void main(String[] args) {
        String sql = "INSERT INTO persons (some_column, birthday) VALUES(?, ?);"; // Prepare the SQL statement including placeholders for input parameters

        // 'connection' is assumed to be your JDBC Connection object here
        Connection connection = null; // Initialize 'connection' (replace with actual connection in real use)

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql); 

            // Assuming 'localDate' is a LocalDate object previously created
            LocalDate localDate = LocalDate.now(); // Placeholder for the actual LocalDate object

            ps.setDate(2, java.sql.Date.valueOf(localDate)); // Setting the date value retrieved from LocalDate object previously created (at index 2 in this example)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}