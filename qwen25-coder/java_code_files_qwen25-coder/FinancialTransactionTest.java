import java.lang.String;
// Example of a simple unit test using JUnit in Java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinancialTransactionTest {

    @Test
    void testProcessTransaction() {
        FinancialTransaction transaction = new FinancialTransaction(100.0, "EUR");
        boolean success = transaction.process();
        assertEquals(true, success, "The transaction should process successfully.");
    }

    public static void main(String[] args) {
    }
}