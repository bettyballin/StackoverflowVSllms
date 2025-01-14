import java.lang.String;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class UpdaterTest {

    private DatabaseHelper mockDatabaseHelper;
    private Updater updater;

    @Before
    public void setUp() {
        // Initialize your mocks here
        mockDatabaseHelper = mock(DatabaseHelper.class);
        updater = new Updater(mockDatabaseHelper);
    }

    @Test
    public void testUpdateRow_CallsInvokeStoredProcedureWithCorrectArgs() {
        // Given
        int id = 1;
        String columnName = "name";
        Object value = "John Doe";

        // When
        updater.updateRow(id, columnName, value);

        // Then - Verify that invokeStoredProcedure was called with the correct arguments
        verify(mockDatabaseHelper).invokeStoredProcedure(eq(id), eq(columnName), eq(value));
    }

    public static void main(String[] args) {
        // You can run your tests here if needed
    }
}

class DatabaseHelper {
    public void invokeStoredProcedure(int id, String columnName, Object value) {
        // Implementation here
    }
}

class Updater {
    private DatabaseHelper databaseHelper;

    public Updater(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void updateRow(int id, String columnName, Object value) {
        databaseHelper.invokeStoredProcedure(id, columnName, value);
    }
}