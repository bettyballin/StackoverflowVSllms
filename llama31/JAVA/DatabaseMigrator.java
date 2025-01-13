import org.flywaydb.core.Flyway;
import javax.sql.DataSource;

public class DatabaseMigrator {
    public static void main(String[] args) {
        // Create a data source, replace with your own data source configuration
        DataSource dataSource = null; // Replace with your data source

        // Flyway configuration
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("classpath:db/migration");

        // Migrate to latest version
        flyway.migrate();
    }
}