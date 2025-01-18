import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBChecker {
    boolean dbExists = false;
    String dbName = "yourDatabaseName";
    String username = "yourUsername";
    String password = "yourPassword";
    String connectionURL = "jdbc:yourDriver://localhost:port;databaseName=" + dbName;

    public DBChecker() {
        try {
            Connection conn = DriverManager.getConnection(connectionURL, username, password);
            dbExists = true;
            if (conn != null && !conn.isClosed()) conn.close(); // close connection when done using it
        } catch (SQLException e) {
            System.out.println("Database does not exist: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create an instance of DBChecker
        DBChecker checker = new DBChecker();
        // You can use checker.dbExists to see if the database exists
    }
}