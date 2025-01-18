import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SafeSqlQueryExecution {
    public static void main(String[] args) {
        String sql = "SELECT * FROM users WHERE age > ?"; // Replace ? with actual value during execution
        Connection connection = null; // Define 'connection' variable
        int minimumAge = 18; // Define 'minimumAge' variable, example value

        try {
            // Initialize the connection (you need to supply your own database URL, username, and password)
            connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user", "password");

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minimumAge); // Replaces first ? placeholder with given value
            ResultSet resultSet = statement.executeQuery();

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                // Example:
                // int id = resultSet.getInt("id");
                // String name = resultSet.getString("name");
                // System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}