import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConfig {
    private static HikariDataSource ds;

    public static void init() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:mydb");
        config.setUsername("sa");
        config.setPassword("");
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(10);
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void main(String[] args) {
        init();
        try (Connection conn = getConnection()) {
            System.out.println("Connection established: " + conn);
        } catch (SQLException e) {
            System.err.println("Error getting connection: " + e.getMessage());
        }
    }
}