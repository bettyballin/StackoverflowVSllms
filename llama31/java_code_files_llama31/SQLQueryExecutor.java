/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLQueryExecutor {
    private final Connection connection;
    private final PreparedStatement statement;

    public SQLQueryExecutor(Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.prepareStatement("SELECT * FROM table WHERE id = ?");
    }

    public synchronized void executeQuery(int n) throws SQLException {
        this.statement.setInt(1, n);
        this.statement.execute();
    }

    public static void main(String[] stringArray) {
    }
}
