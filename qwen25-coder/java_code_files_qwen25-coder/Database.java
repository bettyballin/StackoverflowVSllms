import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.DriverManager;
import java.util.Map;

public class Database {
    private final Connection connection;

    public Database(Connection connection) {
        this.connection = connection;
    }

    public ResultSet query(String sql, Map<String, Object> bindings) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (Map.Entry<String, Object> entry : bindings.entrySet()) {
                stmt.setObject(entry.getKey().substring(1), entry.getValue()); // Adjust index as needed
            }
            return stmt.executeQuery();
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("your_connection_string");
        Database db = new Database(conn);
        String articleName = "someArticle";
        Map<String, Object> bindings = Map.of(":name", articleName);
        ResultSet rs = db.query("SELECT * FROM articles WHERE name = :name", bindings);
        // Process the ResultSet here
    }
}