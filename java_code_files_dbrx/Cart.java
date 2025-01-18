import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    // Other methods can be added here

    public void addItem(LineItem item) {
        if (items.size() < 20) {
            items.add(item);
        } else {
            throw new RuntimeException("Cannot have more than 20 items in the cart.");
        }
    }
}

class LineItem {
    // Definition of LineItem
}