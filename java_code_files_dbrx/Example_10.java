import java.sql.*;

public class Example {
    public static void main(String[] args) {
        try {
            String example = "Hello World"; // String data type.

            Connection conn = null; // Placeholder for database connection.

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO User (Name) VALUES (?)");  // Prepare SQL statement with placeholders '?' for inputs that will be dynamically set.
            stmt.setString(1, example);    // Set first placeholder to value of "example" variable.
            stmt.execute();     // Execute the statement.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}