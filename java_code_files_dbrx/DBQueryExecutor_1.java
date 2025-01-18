import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class DBQueryExecutor_1 {
    public static void main(String[] args) {
        List<Map<String, Object>> result = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/mydb"; // Replace with your database URL

        try (Connection conn = DriverManager.getConnection(url)) {
            QueryRunner run = new QueryRunner();
            String sql = "SELECT * FROM my_table";
            ResultSetHandler<List<Map<String, Object>>> h = new MapListHandler();
            result = run.query(conn, sql, h);
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}