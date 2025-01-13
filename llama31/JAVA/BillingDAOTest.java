import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BillingDAOTest {

    @Mock
    private Connection connection;

    @InjectMocks
    private BillingDAO billingDAO;

    @Test
    public void testGetPaymentStatementForPolicy() {
        // Set up mock data
        Policy policy = new Policy();
        List<PaymentSchedule> paymentSchedules = new ArrayList<>();

        // Mock the database interaction
        when(connection.prepareStatement(anyString())).thenReturn(mock(PreparedStatement.class));

        // Call the DAO method
        List<PaymentSchedule> result = billingDAO.getPaymentStatementForPolicy(policy);

        // Verify the result
        assertEquals(paymentSchedules, result);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("BillingDAOTest");
    }
}