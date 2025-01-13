import java.lang.String;

// Define the missing classes and interfaces
class Order {
    private String userId;

    public Order(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}

class User {
    private String id;

    public User(String id) {
        this.id = id;
    }
}

interface OrderRepository {
    void save(Order order);
}

interface UserService {
    User getUser(String userId);
}

class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

// OrderService.java
public class OrderService_1 {
    private OrderRepository orderRepository;
    private UserService userService;

    public OrderService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public void placeOrder(Order order) {
        // Validate order...

        User user = userService.getUser(order.getUserId());
        if (user == null) {
            throw new ValidationException("User not found");
        }

        orderRepository.save(order);
    }

    public static void main(String[] args) {
        // Example usage
        OrderRepository orderRepository = new OrderRepository() {
            @Override
            public void save(Order order) {
                System.out.println("Order saved");
            }
        };

        UserService userService = new UserService() {
            @Override
            public User getUser(String userId) {
                return new User(userId);
            }
        };

        OrderService orderService = new OrderService(orderRepository, userService);
        orderService.placeOrder(new Order("123"));
    }
}