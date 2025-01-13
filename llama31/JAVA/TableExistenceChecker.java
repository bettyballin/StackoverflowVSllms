import java.lang.String;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableExistenceChecker {
    public static void main(String[] args) {
        // Define the database connection properties
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";
        String tableName = "mytable";

        // Establish a connection to the database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Get the database metadata
            DatabaseMetaData metaData = conn.getMetaData();

            // Check if the table exists
            ResultSet tablesResultSet = metaData.getTables(null, null, tableName, new String[] {"TABLE"});
            if (tablesResultSet.next()) {
                System.out.println("Table " + tableName + " exists.");
            } else {
                System.out.println("Table " + tableName + " does not exist.");
            }
        } catch (SQLException e) {
            System.err.println("Error checking table existence: " + e.getMessage());
        }
    }
}