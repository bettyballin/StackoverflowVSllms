import java.lang.String;
import java.lang.Integer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LargeResultSetFetcher {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourdb";
        String user = "youruser";
        String password = "yourpassword";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Create a statement with fetch size set
            try (Statement stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                stmt.setFetchSize(Integer.MIN_VALUE); // Fetch data row by row

                String query = "SELECT column1, column2, column3 FROM your_big_table";
                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        // Process each row
                        System.out.println(rs.getString("column1") + ", " +
                                           rs.getString("column2") + ", " +
                                           rs.getString("column3"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}