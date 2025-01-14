import java.util.List;

// Example of Option 1
public class User_40 {
    private int id;
    private List<Order> orders;

    public List<Order> getOrders() {
        if (orders == null) {
            OrderDataMapper orderDataMapper = new OrderDataMapper();
            orders = orderDataMapper.findByUserId(id);
        }
        return orders;
    }

    public static void main(String[] args) {
    }
}

// Minimal Order class
class Order {
}

// Minimal OrderDataMapper class
class OrderDataMapper {
    public List<Order> findByUserId(int userId) {
        return null; // Replace with actual implementation if available
    }
}