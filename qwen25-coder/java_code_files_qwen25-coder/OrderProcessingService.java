public class OrderProcessingService {
    public void placeOrder(Order order, Customer customer) {
        if (!isValidCustomer(customer)) {
            throw new InvalidCustomerException("Customer details are invalid.");
        }
        if (!isValidOrder(order, customer)) {
            throw new InvalidOrderException("Order details are invalid based on the customer details.");
        }
        // Proceed with placing the order
    }

    private boolean isValidCustomer(Customer customer) {
        // Complex validation logic
        return true;
    }

    private boolean isValidOrder(Order order, Customer customer) {
        // Complex validation logic involving both Order and Customer
        return true;
    }

    public static void main(String[] args) {
    }
}

class Order {
    // Order properties and methods
}

class Customer {
    // Customer properties and methods
}

class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException(String message) {
        super(message);
    }
}

class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) {
        super(message);
    }
}