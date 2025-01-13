import javax.persistence.EntityManager;
import javax.persistence.Entity;
import java.util.List;

// Assuming Order is an entity class, if not create one
@Entity
class Order {
    private List<OrderItem> orderItems;
    // getters and setters
}

class OrderItem {
    // attributes and getters/setters
}

public class OrderRepository_1_1 {
    private EntityManager entityManager;

    public List<Order> findAllOrders() {
        // Fetch orders with their order items using a single query
        List<Order> orders = entityManager.createQuery("SELECT o FROM Order o JOIN FETCH o.orderItems", Order.class).getResultList();
        
        return orders;
    }

    public static void main(String[] args) {
        // Create an instance of OrderRepository_1 to use it
        OrderRepository_1 orderRepository = new OrderRepository_1();
        // Initialize the EntityManager
        orderRepository.entityManager = Persistence.createEntityManagerFactory("example-unit").createEntityManager();
        List<Order> orders = orderRepository.findAllOrders();
        // Use the orders
    }
}