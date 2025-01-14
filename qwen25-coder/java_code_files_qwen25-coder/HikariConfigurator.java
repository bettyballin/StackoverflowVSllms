import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConfigurator {

    HikariConfig config = new HikariConfig();
    HikariDataSource ds;

    public HikariConfigurator() {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydatabase");
        config.setUsername("user");
        config.setPassword("password");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        // Connection pool settings
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setConnectionTimeout(30000); // 30 seconds

        ds = new HikariDataSource(config);
    }

    public static void main(String[] args) {
        // You can instantiate the configurator here if needed
        // HikariConfigurator configurator = new HikariConfigurator();
    }
}