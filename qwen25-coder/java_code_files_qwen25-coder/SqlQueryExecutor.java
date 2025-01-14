import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlQueryExecutor {
    String columnName = "PERSON.NAME";
    String sql = "SELECT * FROM PERSON ORDER BY " + columnName;

    public static void main(String[] args) {
        SqlQueryExecutor executor = new SqlQueryExecutor();

        String url = "jdbc:your_database_connection_url";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(executor.sql);
            while (rs.next()) {
                // Process the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}