import java.util.List;
import java.util.ArrayList;
// Define an interface for Order data transfer
interface OrderDTO {
    String getId();
    void setId(String id);
    double getTotalAmount();
    void setTotalAmount(double totalAmount);
    // Add more necessary fields
}

// Implement the DTO with a class that can be serialized
class SimpleOrderDTO implements OrderDTO {
    private String id;
    private double totalAmount;

    @Override
    public String getId() { return id; }
    @Override
    public void setId(String id) { this.id = id; }
    @Override
    public double getTotalAmount() { return totalAmount; }
    @Override
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}

// Interface for business logic on the app server
interface OrderService {
    void cancel(String orderId);
    List<OrderDTO> getOrdersByClientId(String clientId);
}

// Concrete implementation of OrderService (app server only)
class DefaultOrderService implements OrderService {
    // Use ORM or other means to fetch data from DB
    @Override
    public void cancel(String orderId) {
        // Logic to cancel an order
    }

    @Override
    public List<OrderDTO> getOrdersByClientId(String clientId) {
        // Fetch orders and convert to DTOs
        return new ArrayList<>();
    }
}

// On the web server, you only have access to OrderDTO and necessary services that expose them
class WebOrderController {
    private final OrderService orderService;

    public WebOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<OrderDTO> getOrders(String clientId) {
        return orderService.getOrdersByClientId(clientId);
    }

    public static void main(String[] args) {
    }
}