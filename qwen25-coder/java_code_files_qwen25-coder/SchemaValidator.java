import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

public class SchemaValidator {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
            .dataSource("jdbc:mysql://localhost:3306/your_database_name", "your_db_username", "your_db_password")
            .locations("classpath:/db/migration")
            .load();

        // Clean the database and apply migrations
        flyway.migrate();
        
        // Get the schema version info
        for (MigrationInfo info : flyway.info().pending()) {
            System.out.println("Pending Migration: " + info.getDescription());
            // Implement warning or notification system here
        }
    }
}