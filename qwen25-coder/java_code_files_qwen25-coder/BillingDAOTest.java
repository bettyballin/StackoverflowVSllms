import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BillingDAOTest {

    @InjectMocks
    private BillingDAO billingDAO;

    @Mock
    private SqlSessionFactory sqlSessionFactory;
    
    @Test
    public void testGetPaymentStatementForPolicy() {
        PaymentSchedule paymentSchedule = new PaymentSchedule();

        Policy policy = new Policy(); // Moved declaration before usage

        try (SqlSession session = mock(SqlSession.class)) {
            when(sqlSessionFactory.openSession()).thenReturn(session);
            Map<String, Object> params = new HashMap<>();
            params.put("policy", policy); // Using the declared 'policy'
            when(session.selectList("getPaymentStatementForPolicy", params))
                    .thenReturn(Collections.singletonList(paymentSchedule));

            List<PaymentSchedule> result = billingDAO.getPaymentStatementForPolicy(policy);

            assertEquals(1, result.size());
        }
    }

    public static void main(String[] args) {
        // Main method content
    }
}

// Stub classes to allow compilation without changing functionality
class PaymentSchedule {
    // Stub implementation
}

class Policy {
    // Stub implementation
}

class BillingDAO {
    // Stub method to mimic actual functionality
    public List<PaymentSchedule> getPaymentStatementForPolicy(Policy policy) {
        return Collections.emptyList();
    }
}