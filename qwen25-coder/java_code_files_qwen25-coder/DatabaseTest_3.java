import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest_3 {
    private static final String URL = "jdbc:oracle:thin:@//your-db-host:1521/your-service-name";
    private static final String USER = "your-user-id";
    private static final String PASSWORD = "your-password";

    public void performDatabaseOperations() {
        Connection connection = null;
        try {
            // Establishing the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // Perform database operations here
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

	public static void main(String[] args) {
	}
}