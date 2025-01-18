import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBQueryExecutor {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("url", "username","password");
        String query = "SELECT * FROM table_name";
        Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);
        // process the result set here
        rs.close();
        stmt.close();
        conn.close();
    }
}