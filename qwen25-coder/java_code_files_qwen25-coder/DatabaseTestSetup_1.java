import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTestSetup {

    @Resource(lookup = "jdbc/MyDataSource")
    private DataSource dataSource;

    @Before
    public void setUpData() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            // Insert test data into the database
        }
    }

    @After
    public void tearDownData() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            // Remove or clean up test data from the database
        }
    }

    @Test
    public void testSomething() {
        // Write your tests here that require test data
    }
}

// Custom annotations to make the code executable without external dependencies
@Retention(RetentionPolicy.RUNTIME)
@interface Resource {
    String lookup();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Before {
}

@Retention(RetentionPolicy.RUNTIME)
@interface After {
}

@Retention(RetentionPolicy.RUNTIME)
@interface Test {
}

// Mock DataSource and Connection interfaces
interface DataSource {
    Connection getConnection() throws SQLException;
}

interface Connection extends AutoCloseable {
    @Override
    void close() throws SQLException;
    // Add other necessary methods as needed
}