import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A_3 {
    private Connection conn = null;

    public A_3(String url, String username, String password) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");
        } catch (ClassNotFoundException e) {
            System.err.println("Derby JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Exception while connecting to the database.");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void invalidate() {
        // Handle invalidation as needed
        System.err.println("Invalidating due to exceptions caught.");
    }

    public static void main(String[] args) {
        A_3 dbConnector = new A_3("jdbc:derby:/path/to/your/database;create=true", "username", "password");
        // Remember to close the connection when done
        dbConnector.closeConnection();
    }
}