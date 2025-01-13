import java.lang.String;

public class DatabaseConfigurator_4_4 {
    public static void main(String[] args) {
        DatabaseConfigurator_4 configurator = new DatabaseConfigurator_4();
        configurator.init();
    }

    public void init() {
        String dbPassword = System.getenv("DB_PASSWORD");
        if (dbPassword == null) {
            // Handle missing password
            System.out.println("Missing database password");
        } else {
            System.out.println("Database password is set");
        }
    }
}