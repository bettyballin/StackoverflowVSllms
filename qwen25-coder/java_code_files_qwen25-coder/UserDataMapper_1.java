import java.util.List;
import java.util.ArrayList;

public class UserDataMapper_1 {
    public User findWithOrders(int userId) {
        User user = findById(userId);
        OrderDataMapper orderDataMapper = new OrderDataMapper();
        user.setOrders(orderDataMapper.findByUserId(userId));
        return user;
    }

    public User findById(int userId) {
        User user = new User();
        user.setId(userId);
        return user;
    }
}

class User {
    private int id;
    private List<Order> orders;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public static void main(String[] args) {
    }
}

class OrderDataMapper {
    public List<Order> findByUserId(int userId) {
        // Return an empty list for simplicity
        return new ArrayList<Order>();
    }
}

class Order {
    // Order properties and methods would go here
}