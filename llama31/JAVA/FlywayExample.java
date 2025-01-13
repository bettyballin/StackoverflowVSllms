import org.flywaydb.core.Flyway;

public class FlywayExample {
    public static void main(String[] args) {
        // Create a new Flyway instance
        Flyway flyway = new Flyway();

        // Set the database connection
        flyway.setDataSource("jdbc:mysql://myServerAddress:3306/myDataBase", "myUsername", "myPassword");

        // Run the SQL script
        flyway.migrate();
    }
}