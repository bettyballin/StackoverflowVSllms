import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreator {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            // Connect to the database
            connection = DriverManager.getConnection("jdbc:hsqldb:mem:test");

            // Create a PreparedStatement
            PreparedStatement pstmt = connection.prepareStatement(
                "CREATE TABLE SomeTable(id INTEGER IDENTITY, text LONGVARCHAR)");

            // Execute the query
            pstmt.executeUpdate();

            System.out.println("Table created successfully");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}