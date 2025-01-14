// Example of using H2 in-memory database for testing
import org.h2.jdbcx.JdbcDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        UserRepositoryTest test = new UserRepositoryTest();
        test.setUp(); // Manually call setup
        test.testAddAndRetrieveUser(); // Manually call test method
    }
}

class DatabaseTestSetup {
    public static DataSource getInMemoryDatabase() throws Exception {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        // Initialize schema and tables
        try (Connection connection = dataSource.getConnection()) {
            connection.createStatement()
                .execute("CREATE TABLE users(id INT PRIMARY KEY, name VARCHAR(255))");
        }

        return dataSource;
    }
}

// Example of a repository using DataSource
interface UserRepository {
    void addUser(String name) throws Exception;
    String getUser(int id) throws Exception;
}

class UserRepositoryImpl implements UserRepository {
    private final DataSource dataSource;

    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addUser(String name) throws Exception {
        int id = (int) (System.currentTimeMillis() % 1000);
        try (Connection connection = dataSource.getConnection()) {
            connection.createStatement()
                .execute("INSERT INTO users(id, name) VALUES (" + id + ", '" + name + "')");
        }
    }

    @Override
    public String getUser(int id) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet = connection.createStatement()
                .executeQuery("SELECT name FROM users WHERE id=" + id);
            return resultSet.next() ? resultSet.getString(1) : null;
        }
    }
}

// Example of a test class
class UserRepositoryTest {
    private static DataSource dataSource;

    public void setUp() throws Exception {
        dataSource = DatabaseTestSetup.getInMemoryDatabase();
    }

    public void testAddAndRetrieveUser() throws Exception {
        UserRepository userRepository = new UserRepositoryImpl(dataSource);
        userRepository.addUser("Alice");

        // Since the ID is generated based on currentTimeMillis, we need to retrieve it dynamically
        int id = (int) (System.currentTimeMillis() % 1000);
        String extractedName = userRepository.getUser(id);
        if (!"Alice".equals(extractedName)) {
            throw new Exception("Test failed: expected 'Alice', got '" + extractedName + "'");
        } else {
            System.out.println("Test passed: User 'Alice' successfully added and retrieved.");
        }
    }
}