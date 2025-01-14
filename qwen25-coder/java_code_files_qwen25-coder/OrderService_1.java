import java.lang.String;

public class OrderService_1 {
    // Example in Java for handling duplicates on backend

    public synchronized void placeOrder(Order order) throws Exception {
        if (!isDuplicateOrder(order)) { // isDuplicateOrder() checks your logic to determine if the order already exists.
            saveOrder(order); // Logic to save the order in the database.
        } else {
            throw new Exception("Duplicate Order detected");
        }
    }
    
    private boolean isDuplicateOrder(Order order) {
        // Logic to check if the order already exists.
        // Placeholder implementation:
        return false;
    }
    
    private void saveOrder(Order order) {
        // Logic to save the order in the database.
        // Placeholder implementation.
    }

    public static void main(String[] args) {
        OrderService_1 service = new OrderService_1();
        Order order = new Order();
        try {
            service.placeOrder(order);
            System.out.println("Order placed successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Order {
    // Order class implementation.
    // Placeholder implementation.
}