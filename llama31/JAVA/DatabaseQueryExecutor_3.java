import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExecutor_3_3 {
    public static void main(String[] args) {
        // Set up the database connection
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Get user input
            String userInput = "your_input";

            // Prepare and execute the query
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM your_table WHERE your_column = ?");
            pstmt.setString(1, userInput);
            ResultSet results = pstmt.executeQuery();

            // Process the results
            while (results.next()) {
                // Handle the results here
            }

            // Close the connection
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database or executing the query.");
        }
    }
}