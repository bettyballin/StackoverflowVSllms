import java.util.*;

public class ShoppingCart_1_1 {
    private Set<LineItem> items = new HashSet<>();

    public void addItem(LineItem item) {
        if (items.size() < 20 && !items.add(item)) {
            // handle error or log a message
            System.out.println("Error adding item to cart.");
        }
    }

    public static void main(String[] args) {
        ShoppingCart_1 cart = new ShoppingCart_1();
        // Example usage
        // cart.addItem(new LineItem());
    }
}

// Define the LineItem class for completeness
class LineItem {
    // Add properties and methods as needed
}