import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PaymentServiceTest {

    private PaymentService paymentService;
    private DatabaseMock databaseMock;

    @Before
    public void setUp() {
        // Use Mockito to create a mock of DatabaseMock
        this.databaseMock = mock(DatabaseMock.class);
        this.paymentService = new PaymentService(databaseMock);
    }

    @Test
    public void testSuccessfulPayment() {
        // Arrange
        when(databaseMock.isAccountActive(anyString())).thenReturn(true);

        // Act
        boolean paymentResult = paymentService.makePayment("12345", 100.0);

        // Assert
        assertTrue(paymentResult);
        verify(databaseMock).debitAccount(eq("12345"), eq(100.0));
    }

    public static void main(String[] args) {
        // Normally, tests are run using a test runner, but we can instantiate and run manually for demonstration
        PaymentServiceTest test = new PaymentServiceTest();
        test.setUp();
        test.testSuccessfulPayment();
    }
}

// PaymentService class definition
class PaymentService {

    private DatabaseMock database;

    public PaymentService(DatabaseMock database) {
        this.database = database;
    }

    public boolean makePayment(String accountId, double amount) {
        if (database.isAccountActive(accountId)) {
            database.debitAccount(accountId, amount);
            return true;
        }
        return false;
    }
}

// DatabaseMock interface definition
interface DatabaseMock {
    boolean isAccountActive(String accountId);
    void debitAccount(String accountId, double amount);
}