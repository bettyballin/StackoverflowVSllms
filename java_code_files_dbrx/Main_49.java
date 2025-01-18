import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        // Configure the Flyway instance
        Flyway flyway = Flyway.configure()
            .dataSource("jdbc:your_database_url", "username", "password")
            .load();
        // Migrate the schema or fail if any failure occurs while migrating
        flyway.migrate();
    }
}