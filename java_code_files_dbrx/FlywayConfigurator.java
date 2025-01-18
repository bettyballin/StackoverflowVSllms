import org.flywaydb.core.Flyway;
public class FlywayConfigurator {
    Flyway flyway = Flyway.configure().dataSource("jdbc:sqlserver://localhost:1433;databaseName=myDatabase", "username", "password").load();
    {
        flyway.migrate();
    }
    public static void main(String[] args) {
    }
}