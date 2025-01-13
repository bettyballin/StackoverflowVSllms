import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderRepository {
    private EntityManager entityManager;

    public OrderRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        entityManager = emf.createEntityManager();
    }

    public List<Order> findAllOrders() {
        // Assume this method fetches all orders from the database
        // using a single query
        List<Order> orders = entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
        
        // For each order, fetch its order items (N additional queries)
        for (Order order : orders) {
            order.getOrderItems().size(); // Triggers a query to fetch order items
        }
        
        return orders;
    }

    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.findAllOrders();
    }
}

class Order {
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

class OrderItem {
    // Add your OrderItem properties and methods here
}