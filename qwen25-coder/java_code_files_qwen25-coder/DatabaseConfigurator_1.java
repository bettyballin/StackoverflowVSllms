import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConfigurator_1 {
    HikariConfig config = new HikariConfig();
    HikariDataSource dataSource;

    {
        config.setJdbcUrl("jdbc:mysql://your_database_url/your_db");
        config.setUsername("db_username");
        config.setPassword("db_password");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args) {
    }
}