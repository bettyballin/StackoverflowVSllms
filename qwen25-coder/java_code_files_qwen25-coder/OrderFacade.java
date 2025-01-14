// Example of a simple Session Facade in Java

public class OrderFacade {
    private OrderService orderService;
    private PaymentService paymentService;

    public OrderFacade(OrderService orderService, PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    public void placeOrder(String orderId, double amount) {
        orderService.createOrder(orderId);
        paymentService.processPayment(amount);
    }

    public static void main(String[] args) {
    }
}

class OrderService {
    public void createOrder(String orderId) {
        // Implementation here
    }
}

class PaymentService {
    public void processPayment(double amount) {
        // Implementation here
    }
}