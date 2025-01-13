import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnector {

    public static void main(String[] args) {
        try {
            // Create a new connection
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase",
                "myuser",
                "mypassword"
            );

            // Create a new statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Print the results
            while (resultSet.next()) {
                System.out.println(resultSet.getString("mycolumn"));
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}