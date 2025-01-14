public class OrderProcessor {
    // Before refactoring - Large function
    void processOrderBefore(Order order) {
        validateOrder(order);
        calculateTotal(order);
        applyDiscountsToOrder(order);
        saveToDatabase(order);
        sendConfirmationEmail(order);
    }

    // After refactoring - Smaller, more focused functions
    void processOrder(Order order) {
        validateOrder(order);
        double total = calculateTotal(order);
        total = applyDiscounts(total);
        OrderRepository.save(order);
        EmailService.sendConfirmation(order);
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        Order order = new Order();
        processor.processOrder(order);
    }

    void validateOrder(Order order) {
        // Placeholder implementation
    }

    double calculateTotal(Order order) {
        // Placeholder implementation
        return 0.0;
    }

    void applyDiscountsToOrder(Order order) {
        // Placeholder implementation
    }

    double applyDiscounts(double total) {
        // Placeholder implementation
        return total;
    }

    void saveToDatabase(Order order) {
        // Placeholder implementation
    }

    void sendConfirmationEmail(Order order) {
        // Placeholder implementation
    }
}

class Order {
    // Placeholder implementation
}

class OrderRepository {
    static void save(Order order) {
        // Placeholder implementation
    }
}

class EmailService {
    static void sendConfirmation(Order order) {
        // Placeholder implementation
    }
}