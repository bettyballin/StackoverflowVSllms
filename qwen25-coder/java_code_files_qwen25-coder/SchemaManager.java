import org.flywaydb.core.Flyway;

public class SchemaManager {
    public void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                              .dataSource("jdbc:oracle:thin:@localhost:1521:xe", "user", "password")
                              .locations("classpath:/db/migration") // location of migration scripts
                              .load();

        flyway.migrate(); // apply migrations
    }

    public static void main(String[] args) {
    }
}