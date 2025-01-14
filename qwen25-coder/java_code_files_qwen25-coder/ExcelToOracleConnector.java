import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExcelToOracleConnector {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
        String user = "yourUsername";
        String password = "yourPassword";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM your_table")) {

            while (rs.next()) {
                // Process the result set
                System.out.println(rs.getString("column_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}