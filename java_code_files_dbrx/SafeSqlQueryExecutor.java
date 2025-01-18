import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SafeSqlQueryExecutor {
    String query = "SELECT * FROM foo WHERE date = ?"; // The question mark is a placeholder for the actual value
    Connection conn;
    PreparedStatement stmt;
    ResultSet result;

    {
        stmt = conn.prepareStatement(query);
        stmt.setDate(1, java.sql.Date.valueOf("2009-09-09")); // This will handle conversions specific to your current database type at runtime
        result = stmt.executeQuery();
    }

    public static void main(String[] args) {
    }
}