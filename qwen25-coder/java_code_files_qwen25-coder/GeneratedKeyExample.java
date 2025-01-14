import java.sql.*;

public class GeneratedKeyExample {

    public static void main(String[] args) {

        Connection connection = null;

        try {

            // Load JDBC driver (replace with your specific driver class)
            // For example, for MySQL:
            // Class.forName("com.mysql.jdbc.Driver");
            // For PostgreSQL:
            // Class.forName("org.postgresql.Driver");
            // Replace 'your.jdbc.driver.ClassName' with your actual driver class name
            Class.forName("your.jdbc.driver.ClassName");

            // Establish the connection (replace with your actual database URL, username, and password)
            String url = "jdbc:yourDatabaseURL";
            String username = "yourUsername";
            String password = "yourPassword";
            connection = DriverManager.getConnection(url, username, password);

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO test (myNum) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, 555);

            // Execute the query
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Generated Key: " + id);
                } else {
                    throw new SQLException("Creating test failed, no ID obtained.");
                }
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
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