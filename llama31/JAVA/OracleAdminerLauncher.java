import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class OracleAdminerLauncher {
    public static void main(String[] args) throws SQLException {
        // Create an Oracle data source
        DataSource oracleDS = getOracleDataSource();

        // Create an Adminer instance
        Adminer adminer = new Adminer(oracleDS);

        // Start the Adminer web server
        adminer.start();
    }

    private static DataSource getOracleDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/ORCL");
        ds.setUsername("username");
        ds.setPassword("password");
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        return ds;
    }
}

class Adminer {
    private DataSource dataSource;

    public Adminer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void start() {
        // Implement Adminer start logic here
    }
}