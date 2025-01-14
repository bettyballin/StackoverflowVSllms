import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

public class DatabaseMigrator {
    public static void main(String[] args) throws Exception {
        Liquibase liquibase = createLiquibase();
        liquibase.update("");
    }

    private static Liquibase createLiquibase() throws Exception {
        ClassLoaderResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(getConnection()));
        return new Liquibase("db.changelog-master.yaml", resourceAccessor, database);
    }

    private static Connection getConnection() throws SQLException {
        // Use your connection settings
        return DriverManager.getConnection("jdbc:postgresql://localhost/exampledb", "username", "password");
    }
}