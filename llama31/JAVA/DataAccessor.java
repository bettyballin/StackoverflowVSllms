import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

// Assume we have a DatabaseConnection interface
interface DatabaseConnection {
    void connect();
    void executeQuery(String query);
}

// And a class that uses the DatabaseConnection
class DataAccessor {
    private DatabaseConnection dbConnection;

    public DataAccessor(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void fetchData() {
        dbConnection.connect();
        dbConnection.executeQuery("SELECT * FROM data");
    }
}

// Test class
@RunWith(MockitoJUnitRunner.class)
public class DataAccessorTest {
    @Mock
    private DatabaseConnection dbConnection;

    @InjectMocks
    private DataAccessor dataAccessor;

    @Test
    public void testFetchData() {
        // Verify the downwards-contract
        dataAccessor.fetchData();
        verify(dbConnection).connect();
        verify(dbConnection).executeQuery("SELECT * FROM data");
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("DataAccessorTest");
    }
}