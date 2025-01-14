import java.util.List;
import java.util.ArrayList;

// Simple case without interfaces
class Order {
    private String id;
    private double amount;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    // Getters and setters...
}

public class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    // Getters and setters...

    public static void main(String[] args) {
    }
}