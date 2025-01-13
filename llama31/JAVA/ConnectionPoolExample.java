import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPoolExample {
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
        config.setUsername("myuser");
        config.setPassword("mypassword");
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(20);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setValidationQuery("SELECT 1");
        config.setValidationTimeout(3000);

        HikariDataSource ds = new HikariDataSource(config);
        
        // Use the data source to retrieve connections
        Connection conn = ds.getConnection();
        System.out.println("Connection established: " + conn.isValid(1000));
        conn.close();
    }
}