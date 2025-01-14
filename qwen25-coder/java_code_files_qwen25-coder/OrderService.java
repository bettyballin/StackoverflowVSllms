import java.lang.String;

public class OrderService {
    private final UserService userService;
    private final PaymentService paymentService;
    
    public OrderService(UserService userService, PaymentService paymentService) {
        this.userService = userService;
        this.paymentService = paymentService;
    }
    
    public void placeOrder(Order order, int userId) {
        // Check if the user exists using UserService
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
    
        // Process payment through PaymentService
        paymentService.processPayment(order.getPaymentDetails());
    
        // Save order logic here or in a dedicated repository
    }
    
    public static void main(String[] args) {
        // Example usage
        UserService userService = new UserService();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(userService, paymentService);
        
        Order order = new Order();
        int userId = 1;
        orderService.placeOrder(order, userId);
    }
}

class UserService {
    public User getUserById(int userId) {
        return new User(); // For simplicity, always return a new User
    }
}

class PaymentService {
    public void processPayment(PaymentDetails paymentDetails) {
        // Process payment logic
    }
}

class Order {
    public PaymentDetails getPaymentDetails() {
        return new PaymentDetails();
    }
}

class User {
    // User properties and methods
}

class PaymentDetails {
    // Payment details properties and methods
}