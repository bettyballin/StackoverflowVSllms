import java.lang.String;
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

    public synchronized void executeQuery(int id) throws SQLException {
        statement.setInt(1, id);
        statement.execute();
    }

	public static void main(String[] args) {
	}
}