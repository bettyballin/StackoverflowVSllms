import java.sql.Connection;
import java.sql.Statement;

public class SQLQueryExecutor {
    String query = "CREATE TABLE NEW_TABLE AS SELECT * FROM FRED WHERE 1=0";
    Statement stmt;
    Connection connection;

    public SQLQueryExecutor() throws Exception {
        stmt = connection.createStatement();
        stmt.execute(query);
    }

    public static void main(String[] args) throws Exception {
    }
}