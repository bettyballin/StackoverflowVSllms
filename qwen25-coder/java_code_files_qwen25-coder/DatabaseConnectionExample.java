import java.lang.String;
// Example of connecting to MySQL using JDBC
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/yourDatabaseName";
            String user = "yourUsername";
            String password = "yourPassword";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the MySQL server successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (connection != null) connection.close(); } catch(Exception e) { e.printStackTrace(); }
        }
    }
}