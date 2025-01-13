import java.lang.String;

// Utility function: okay to use static method
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}

// Business logic: better to use instance method
class PaymentGateway {
    public void charge(int amount) {
        // implementation of charging logic
    }
}

class Order {
    public int getTotal() {
        // implementation of getting total
        return 0;
    }
}

public class OrderService {
    private PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processOrder(Order order) {
        // instance method allows for dependency injection and testing
        paymentGateway.charge(order.getTotal());
    }

    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGateway();
        OrderService orderService = new OrderService(paymentGateway);
        Order order = new Order();
        orderService.processOrder(order);
    }
}