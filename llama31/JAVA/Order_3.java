import java.util.List;
import java.util.ArrayList;

// Define the Customer class
class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Define the OrderItem class
class OrderItem {
    private String product;
    private int quantity;

    public OrderItem(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Define the PostalAddress class
class PostalAddress {
    private String street;
    private String city;

    public PostalAddress(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
}

// Define the OrderValidator class
class OrderValidator {
    public void validate(Order_3 order) {
        // Basic validation: check for null values
        if (order.getCustomer() == null) {
            System.out.println("Invalid order: customer is null");
        }
        if (order.getOrderItems() == null || order.getOrderItems().isEmpty()) {
            System.out.println("Invalid order: order items are null or empty");
        }
        if (order.getShippingAddress() == null) {
            System.out.println("Invalid order: shipping address is null");
        }
    }
}

public class Order_3_3 {
    private Customer customer;
    private List<OrderItem> orderItems;
    private PostalAddress shippingAddress;

    public Order_3(Customer customer, List<OrderItem> orderItems, PostalAddress shippingAddress) {
        this.customer = customer;
        this.orderItems = orderItems;
        this.shippingAddress = shippingAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public PostalAddress getShippingAddress() {
        return shippingAddress;
    }

    public void validate() {
        OrderValidator validator = new OrderValidator();
        validator.validate(this);
    }

    public static void main(String[] args) {
        // Create example data
        Customer customer = new Customer("John Doe");
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("Product A", 2));
        orderItems.add(new OrderItem("Product B", 1));
        PostalAddress shippingAddress = new PostalAddress("123 Main St", "Anytown");

        // Create an Order_3 instance and validate it
        Order_3 order = new Order_3(customer, orderItems, shippingAddress);
        order.validate();
    }
}