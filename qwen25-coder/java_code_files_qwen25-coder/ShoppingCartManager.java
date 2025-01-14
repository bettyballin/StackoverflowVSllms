import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class ShoppingCartManager {
    private List<LineItem> items = new ArrayList<>();

    public void addItem(LineItem item) {
        if (items.size() < 20) { // Check if the list has less than 20 items
            items.add(item); // Add the new item
        } else {
            System.out.println("Cannot add more items, cart is full."); // Optional: log a message
        }
    }

    public static void main(String[] args) {
    }
}

class LineItem {
    // Placeholder for LineItem class
}