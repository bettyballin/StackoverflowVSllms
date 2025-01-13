import oracle.jdbc.pool.OracleDataSource;

public class Main_289 {
    public static void main(String[] args) {
        // Assuming 'ods' is an instance of OracleDataSource
        OracleDataSource ods = new OracleDataSource();
        ods.setNLSCharset("US-ASCII"); // or the actual character set used by your database
    }
}