import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Set;

public class OrderPaymentIntegrationTest {

    // Define orderService and paymentService
    private OrderService orderService = new OrderService();
    private PaymentService paymentService = new PaymentService();

    // Test case: Place an order and verify payment processing
    @Test
    public void testOrderPaymentIntegration() {
        // Set up test data
        Order order = new Order();
        order.setCustomerId(123);
        order.setTotal(100.00);

        // Call OrderService to place the order
        OrderResponse orderResponse = orderService.placeOrder(order);

        // Verify order response
        assertEquals(OrderStatus.SUCCESS, orderResponse.getStatus());

        // Call PaymentService to process payment
        PaymentResponse paymentResponse = paymentService.processPayment(orderResponse.getOrderId());

        // Verify payment response
        assertEquals(PaymentStatus.APPROVED, paymentResponse.getStatus());
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("OrderPaymentIntegrationTest");
    }
}

// Define Order class
class Order {
    private int customerId;
    private double total;

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotal() {
        return total;
    }
}

// Define OrderResponse class
class OrderResponse {
    private OrderStatus status;
    private int orderId;

    public OrderResponse(OrderStatus status, int orderId) {
        this.status = status;
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getOrderId() {
        return orderId;
    }
}

// Define OrderStatus enum
enum OrderStatus {
    SUCCESS,
    FAILURE
}

// Define PaymentResponse class
class PaymentResponse {
    private PaymentStatus status;

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}

// Define PaymentStatus enum
enum PaymentStatus {
    APPROVED,
    DECLINED
}

// Define OrderService class
class OrderService {
    public OrderResponse placeOrder(Order order) {
        // Simulate placing an order
        return new OrderResponse(OrderStatus.SUCCESS, 1);
    }
}

// Define PaymentService class
class PaymentService {
    public PaymentResponse processPayment(int orderId) {
        // Simulate processing a payment
        return new PaymentResponse(PaymentStatus.APPROVED);
    }
}