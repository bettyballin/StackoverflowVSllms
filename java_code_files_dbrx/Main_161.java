import java.lang.String;
import java.sql.*;
import com.internetitem.jdbc_profiler.*;

public class Main_161 {
    public static void main(String[] args) throws Exception {
        // Create profiler with default settings
        ProfiledDataSource dataSource = new ProfiledDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/database-name", "username", "password");

        try (Connection connection = dataSource.getConnection()) {
            // Execute your DB operations and statements here within the connection object; for example:
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tableName");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "    " + rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the ProfiledDataSource to ensure that JDBCProfiler can log all queries and their statistics.
            dataSource.close();
        }
    }
}