import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PaymentScheduleRetrievalComponentTest {
    @Mock
    private BillingDAO billingDAO;

    @InjectMocks
    private PaymentScheduleRetrievalComponent component;

    @Test
    public void testExecute() {
        // Set up mock data
        Policy policy = new Policy();
        List<PaymentSchedule> paymentSchedules = new ArrayList<>();

        // Mock the database interaction
        Mockito.when(billingDAO.getPaymentStatementForPolicy(policy)).thenReturn(paymentSchedules);

        // Call the web service method
        component.execute(Mockito.mock(Context.class));

        // Verify the result
        Mockito.verify(billingDAO, Mockito.times(1)).getPaymentStatementForPolicy(policy);
    }

    public static void main(String[] args) {
    }
}