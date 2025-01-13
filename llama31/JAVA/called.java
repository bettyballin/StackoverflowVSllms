import org.mockito.Mockito;
import java.lang.String;

public class called {
    // Assume you're testing a class called OrderProcessor
    // and you discover that it needs to delegate to a new class called PaymentGateway

    public static void main(String[] args) {
        // Create a mock for PaymentGateway
        PaymentGateway paymentGatewayMock = Mockito.mock(PaymentGateway.class);

        // Use the mock in your OrderProcessor test
        OrderProcessor orderProcessor = new OrderProcessor(paymentGatewayMock);

        // Continue writing tests for OrderProcessor using the mock
    }
}

class PaymentGateway {}

class OrderProcessor {
    public OrderProcessor(PaymentGateway paymentGateway) {}
}