import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInserter_4_4 {
    public static void main(String[] args) {
        // Assuming you have a JDBC driver and a database connection string
        String dbUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String dbUser = "myuser";
        String dbPassword = "mypassword";

        String userInput = "Hello, World!"; // Replace with actual user input

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO table (column) VALUES (?)");
            pstmt.setString(1, userInput); // userInput can contain special characters like ' and "
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting into database: " + e.getMessage());
        }
    }
}