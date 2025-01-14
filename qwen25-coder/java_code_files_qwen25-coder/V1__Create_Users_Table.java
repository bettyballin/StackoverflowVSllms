import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// Stub interface to allow compilation
interface JdbcMigration {
    void migrate(Connection connection) throws SQLException;
}

public class V1__Create_Users_Table implements JdbcMigration {
    @Override
    public void migrate(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) NOT NULL, email VARCHAR(50))");
        }
    }

    // Optional: implement undo migration if supported/needed

    public static void main(String[] args) {
        // Main method implementation if needed
    }
}