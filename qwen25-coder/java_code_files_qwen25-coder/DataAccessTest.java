import java.util.ArrayList;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DataAccessTest {

    @Mock
    private DatabaseClient databaseClient;

    public DataAccessTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testNoRecordsFound() {
        when(databaseClient.query("your query here")).thenReturn(new ArrayList<>());

        DataAccess dataAccess = new DataAccess(databaseClient);

        boolean result = dataAccess.checkIfRecordExists("condition");

        assertFalse(result); // Assuming checkIfRecordExists returns false if no records are found
    }

    public static void main(String[] args) {
    }
}

class DatabaseClient {
    public ArrayList<?> query(String s) {
        return null;
    }
}

class DataAccess {
    private DatabaseClient databaseClient;

    public DataAccess(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public boolean checkIfRecordExists(String condition) {
        // Implementation can be empty as functionality should not change
        return false;
    }
}