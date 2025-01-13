import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory_1 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";

    public enum Database {
        DB1("db1"),
        DB2("db2");

        private final String name;

        Database(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static Connection getConnection(Database database) throws SQLException {
        return DriverManager.getConnection(DB_URL + database.getName(), DB_USER, DB_PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection db1Connection = DatabaseConnectionFactory.getConnection(Database.DB1);
            Connection db2Connection = DatabaseConnectionFactory.getConnection(Database.DB2);
            // Use the connections
        } catch (SQLException e) {
            // Handle the exception
        }
    }
}