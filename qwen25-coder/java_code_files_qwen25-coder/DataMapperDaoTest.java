import java.lang.String;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

// Interface for Database connection
interface DbConnection {
    Object query(String sql);
    void execute(String sql);
}

// Data Access Object class
class DataMapperDao {
    private final DbConnection dbConnection;

    public DataMapperDao(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String fetchData(String id) {
        return (String) dbConnection.query("SELECT * FROM table WHERE id=" + id);
    }
}

// Test class
public class DataMapperDaoTest {
    private DbConnection mockDbConnection;
    private DataMapperDao dataMapperDao;

    @Before
    public void setUp() throws Exception {
        // Create mock object using Mockito
        mockDbConnection = mock(DbConnection.class);

        // Return a predefined value when query method is called with specific argument
        when(mockDbConnection.query("SELECT * FROM table WHERE id=1")).thenReturn("Test Data");

        // Initialize the DAO with the mock connection
        dataMapperDao = new DataMapperDao(mockDbConnection);
    }

    @Test
    public void testDataFetch() throws Exception {
        String result = dataMapperDao.fetchData("1");
        assertEquals("Test Data", result);

        // Verify that query was called exactly once with the given argument
        verify(mockDbConnection).query("SELECT * FROM table WHERE id=1");
    }

    public static void main(String[] args) {
        // Run the tests
        org.junit.runner.JUnitCore.main("DataMapperDaoTest");
    }
}