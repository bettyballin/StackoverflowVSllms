import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public interface Connection {
        Statement createStatement() throws SQLException;
        void commit() throws SQLException;
        void close() throws SQLException;
        // ...
    }

    public static void main(String[] args) {
    }
}