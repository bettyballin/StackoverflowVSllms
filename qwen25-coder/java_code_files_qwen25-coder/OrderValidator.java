import java.lang.String;
public class OrderValidator {
    private final Customer customer;

    public OrderValidator(Customer customer) {
        this.customer = customer;
    }

    public void validate(Order order) {
        if (!isValidOrder(order)) {
            throw new InvalidOrderException("Order details are invalid.");
        }
        // Additional validation logic can be added here
    }

    private boolean isValidOrder(Order order) {
        return true; // Complex logic involving both Customer and Order
    }

    public static void main(String[] args) {
    }

}

class Customer {
    // Placeholder for Customer class
}

class Order {
    // Placeholder for Order class
}

class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message);
    }
}