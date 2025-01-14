import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBQueryExecutor {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASS = "password";
    private static final String SQL_QUERY1 = "SELECT * FROM table1";
    private static final String SQL_QUERY2 = "SELECT * FROM table2";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt1 = conn.createStatement();
             ResultSet rs = stmt1.executeQuery(SQL_QUERY1);
             Statement stmt2 = conn.createStatement();
             ResultSet rs2 = stmt2.executeQuery(SQL_QUERY2)) {

            while (rs.next()) {
                // Process data from first ResultSet
            }

            while (rs2.next()) {
                // Process data from second ResultSet
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}