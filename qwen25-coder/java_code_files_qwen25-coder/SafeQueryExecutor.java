import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SafeQueryExecutor {
    String query = "SELECT * FROM <tablename> WHERE 1 = 0";
    String url = "jdbc:your_database_url";
    String username = "your_username";
    String password = "your_password";

    public void executeQuery() {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData metaData = rs.getMetaData();
            // Use metaData to get column information
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SafeQueryExecutor executor = new SafeQueryExecutor();
        executor.executeQuery();
    }
}