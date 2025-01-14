import java.lang.String;
// Import necessary classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector_6 {
    public static void main(String[] args) {
        // Retrieve password from environment variable
        String dbPassword = System.getenv("DB_PASSWORD");
        
        if (dbPassword == null) {
            throw new RuntimeException("DB_PASSWORD environment variable not set.");
        }

        // Define database connection parameters
        String url = "jdbc:mysql://localhost:3306/yourDatabase";
        String user = "databaseUser";

        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(url, user, dbPassword);
            System.out.println("Connection made successfully.");

            // Perform operations with the database

            // Close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}