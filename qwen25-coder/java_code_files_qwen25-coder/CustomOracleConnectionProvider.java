import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomOracleConnectionProvider {
    private DataSource dataSource;

    public CustomOracleConnectionProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        final Connection conn = dataSource.getConnection();
        if (conn instanceof OracleConnection) {
            return conn;
        } else if (conn.unwrap(OracleConnection.class) != null) {
            return conn.unwrap(OracleConnection.class);
        }
        throw new SQLException("Unable to unwrap connection");
    }

    public static void main(String[] args) {
    }
}

interface OracleConnection extends Connection {
    // Define any required methods here
}