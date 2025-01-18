import java.sql.*;

public class InsertStatementWithGeneratedKeys {
    public static void main(String[] args) {
        // Assume that a database connection is established here
        Connection connection = null;

        try {
            // Replace the following with your actual database connection code
            // For example:
            // String url = "jdbc:your_database_url";
            // String user = "your_username";
            // String password = "your_password";
            // connection = DriverManager.getConnection(url, user, password);

            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO test(myNum) VALUES(?)", Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1, 555);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1); // Here's the value saved
                    System.out.println("The newly created ID is: " + generatedId);
                } else {
                    System.err.println("Generated keys cannot be retrieved.");
                }
            } else {
                System.err.println("No rows affected during insert!");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}