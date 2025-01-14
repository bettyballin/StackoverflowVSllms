import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class LegacyCodeTest {

    // Assuming 'DatabaseService' is an interface with a method 'fetchData'
    interface DatabaseService {
        Object fetchData();
    }

    class LegacyCode {
        public Object legacyMethodThatProcessesDatabaseCall(DatabaseService dbService) {
            // Implement logic that processes the database call
            return dbService.fetchData();
        }
    }

    @Test
    public void testFetchData() {
        Object expectedData = "Expected Data";
        Object expectedResult = "Expected Data";

        DatabaseService mockDb = mock(DatabaseService.class);
        when(mockDb.fetchData()).thenReturn(expectedData);

        // Your legacy method that uses the database service
        LegacyCode code = new LegacyCode();
        assertEquals(expectedResult, code.legacyMethodThatProcessesDatabaseCall(mockDb));
    }
}