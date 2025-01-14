import java.sql.Connection;
import java.sql.Statement;

public class SqlExecutor_1 {
    String sql = "ALTER TABLE table_name MODIFY COLUMN column1 int COMMENT 'This is the description for column1';";
    Connection conn; // Assume conn is initialized elsewhere

    public SqlExecutor_1() {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}