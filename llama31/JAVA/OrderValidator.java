import java.lang.String;
import java.util.List;

// Define the InvalidOrderException class
class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message);
    }
}

// Define the Order class
class Order {
    private Customer customer;
    private List<OrderItem> orderItems;
    private PostalAddress shippingAddress;

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public PostalAddress getShippingAddress() {
        return shippingAddress;
    }
}

// Define the Customer class
class Customer {
    private String id;

    public String getId() {
        return id;
    }
}

// Define the OrderItem class
class OrderItem {
}

// Define the PostalAddress class
class PostalAddress {
    public boolean isValid() {
        // Add logic to validate the postal address
        return true; // For demonstration purposes only
    }
}

public class OrderValidator {
    public void validate(Order order) throws InvalidOrderException {
        if (order.getCustomer() == null || order.getCustomer().getId() == null) {
            throw new InvalidOrderException("Invalid customer");
        }
        if (order.getOrderItems().isEmpty()) {
            throw new InvalidOrderException("No order items");
        }
        PostalAddress shippingAddress = order.getShippingAddress();
        if (shippingAddress == null || !shippingAddress.isValid()) {
            throw new InvalidOrderException("Invalid shipping address");
        }
        // Additional validation logic...
    }

    public static void main(String[] args) {
        // Create an instance of OrderValidator and test the validate method
        OrderValidator validator = new OrderValidator();
        try {
            // Create a sample Order object
            Order order = new Order();
            // Set the customer, order items, and shipping address for the order
            // ...
            validator.validate(order);
        } catch (InvalidOrderException e) {
            System.out.println(e.getMessage());
        }
    }
}