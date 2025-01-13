import java.util.List;
import java.util.ArrayList;

class Order {
    // Define the Order class
}

public class Customer_6_6 {
    private List<Order> orders;

    public Customer_6() {
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public static void main(String[] args) {
    }
}