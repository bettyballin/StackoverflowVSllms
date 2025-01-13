import java.lang.String;
import java.sql.*;

public class DataSetExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Establish a database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Create a statement to execute a query
            Statement stmt = conn.createStatement();

            // Execute a query and get the result set
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM mytable");

            // Iterate over the result set and print the data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close the resources
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // Handle the exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}