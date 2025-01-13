import java.lang.String;

// Before: tightly coupled and untestable
class Order {
}

interface OrderRepository {
    void save(Order order);
}

class OrderRepositoryImpl implements OrderRepository {
    public void save(Order order) {
        // save order logic here
    }
}

public class OrderService_2 {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
        // Complex business logic
        orderRepository.save(order);
    }

    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepositoryImpl();
        OrderService orderService = new OrderService(orderRepository);
        Order order = new Order();
        orderService.placeOrder(order);
    }
}