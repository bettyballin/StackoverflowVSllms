import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class JavaDatabaseConfigurator {
    // Create a test data source
    private static BasicDataSource testDataSource = new BasicDataSource();

    static {
        testDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
        testDataSource.setUsername("myuser");
        testDataSource.setPassword("mypassword");
    }

    // Use the test data source in your test code
    private static javax.sql.DataSource dataSource = testDataSource;

    public static void main(String[] args) throws SQLException {
        // You can use the dataSource here
        System.out.println(dataSource.toString());
    }
}