import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class PreparedStatementCache {
    private ConcurrentHashMap<String, String> queryCache = new ConcurrentHashMap<>();
    private ThreadLocal<PreparedStatement> statementThreadLocal = new ThreadLocal<>();

    public PreparedStatement getPreparedStatement(Connection conn, String sql) throws SQLException {
        if (queryCache.containsKey(sql)) {
            // If the query is already in the cache, retrieve the corresponding PreparedStatement object
            String query = queryCache.get(sql);
            PreparedStatement stmt = statementThreadLocal.get();
            if (stmt == null || !stmt.toString().equals(query)) {
                // If the thread-local PreparedStatement object is null or doesn't match the query, create a new one
                stmt = conn.prepareStatement(query);
                statementThreadLocal.set(stmt);
            }
            return stmt;
        } else {
            // If the query is not in the cache, create a new PreparedStatement object and store it in the cache
            PreparedStatement stmt = conn.prepareStatement(sql);
            queryCache.put(sql, sql);
            statementThreadLocal.set(stmt);
            return stmt;
        }
    }

    public static void main(String[] args) {
        // Create a new instance of PreparedStatementCache
        PreparedStatementCache cache = new PreparedStatementCache();

        // Create a mock Connection object (replace with your actual Connection object)
        Connection conn = null;

        try {
            // Test the getPreparedStatement method
            PreparedStatement stmt = cache.getPreparedStatement(conn, "SELECT * FROM table");
            System.out.println(stmt);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}