import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConfigurator {
    HikariDataSource dataSource;

    public DatabaseConfigurator() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/yourdb");
        config.setUsername("yourUsername");
        config.setPassword("yourPassword");

        // Assuming analysis suggests a reasonable pool size of 200 for your scenario.
        config.setMaximumPoolSize(200);

        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args) {
        DatabaseConfigurator configurator = new DatabaseConfigurator();
    }
}