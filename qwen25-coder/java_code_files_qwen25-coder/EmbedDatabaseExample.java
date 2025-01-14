import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class EmbedDatabaseExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Register JDBC driver
        Class.forName("org.h2.Driver");

        try (Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO strings (value) VALUES (?)")) {

            // Create table
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS strings(value VARCHAR(255))");

            // Example Vector of Strings
            Vector<String> stringVector = new Vector<>();
            stringVector.add("Hello");
            stringVector.add("World");
            stringVector.add("Example");

            // Insert data into table
            for (String s : stringVector) {
                stmt.setString(1, s);
                stmt.executeUpdate();
            }

            System.out.println("Strings inserted successfully.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}