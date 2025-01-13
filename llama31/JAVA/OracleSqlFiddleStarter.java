import java.lang.String;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleSqlFiddleStarter {
    public static void main(String[] args) throws SQLException {
        // Create a Oracle data source
        OracleDataSource oracleDS = new OracleDataSource();
        oracleDS.setURL("jdbc:oracle:thin:@//localhost:1521/ORCL");
        oracleDS.setUser("username");
        oracleDS.setPassword("password");

        // Create a SQL Fiddle instance
        SqlFiddle sqlFiddle = new SqlFiddle(oracleDS);

        // Start the SQL Fiddle web server
        sqlFiddle.start();
    }
}

class SqlFiddle {
    private OracleDataSource oracleDS;

    public SqlFiddle(OracleDataSource oracleDS) {
        this.oracleDS = oracleDS;
    }

    public void start() {
        // Code to start the SQL Fiddle web server
        System.out.println("SQL Fiddle web server started");
    }
}