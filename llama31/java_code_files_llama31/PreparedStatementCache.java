/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class PreparedStatementCache {
    private ConcurrentHashMap<String, String> queryCache = new ConcurrentHashMap();
    private ThreadLocal<PreparedStatement> statementThreadLocal = new ThreadLocal();

    public PreparedStatement getPreparedStatement(Connection connection, String string) throws SQLException {
        if (this.queryCache.containsKey(string)) {
            String string2 = this.queryCache.get(string);
            PreparedStatement preparedStatement = this.statementThreadLocal.get();
            if (preparedStatement == null || !preparedStatement.toString().equals(string2)) {
                preparedStatement = connection.prepareStatement(string2);
                this.statementThreadLocal.set(preparedStatement);
            }
            return preparedStatement;
        }
        PreparedStatement preparedStatement = connection.prepareStatement(string);
        this.queryCache.put(string, string);
        this.statementThreadLocal.set(preparedStatement);
        return preparedStatement;
    }

    public static void main(String[] stringArray) {
        PreparedStatementCache preparedStatementCache = new PreparedStatementCache();
        Connection connection = null;
        try {
            PreparedStatement preparedStatement = preparedStatementCache.getPreparedStatement(connection, "SELECT * FROM table");
            System.out.println(preparedStatement);
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
