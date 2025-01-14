import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConcurrentQueriesExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection1 = DriverManager.getConnection(url, user, password);
             Connection connection2 = DriverManager.getConnection(url, user, password)) {

            String query1 = "SELECT * FROM table1 WHERE condition1";
            String query2 = "SELECT * FROM table2 WHERE condition2";

            try (PreparedStatement stmt1 = connection1.prepareStatement(query1);
                 PreparedStatement stmt2 = connection2.prepareStatement(query2)) {

                ResultSet rs1 = stmt1.executeQuery();
                ResultSet rs2 = stmt2.executeQuery();

                // Process results
                processResultSet(rs1);
                processResultSet(rs2);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processResultSet(ResultSet rs) throws Exception {
        while (rs.next()) {
            // Process each row
        }
    }
}