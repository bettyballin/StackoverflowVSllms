import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//yourHost:port/serviceName";
        String user = "yourUsername"; // Your database username
        String password = "yourPassword"; // Your database password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Querying another user's table, e.g., USER1.TABLE_NAME
            String sql = "SELECT * FROM USER1.TABLE_NAME";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Retrieve data from the result set
                System.out.println(rs.getString("columnName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}