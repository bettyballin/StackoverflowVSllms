import java.lang.String;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorDatabaseIntegrationTest {
    @Test
    public void calculateAndStore() {
        int result = new Calculator().add(2, 3); // Calculate
        Database db = new Database();           // Database connection

        db.storeResult(result);                  // Store in database
        assertEquals(5, db.getLatestEntry());    // Verify
    }

    public static void main(String[] args) {
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

class Database {
    private int latestEntry;

    public void storeResult(int result) {
        latestEntry = result;
    }

    public int getLatestEntry() {
        return latestEntry;
    }
}