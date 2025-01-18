import java.util.Arrays;
import java.util.List;

class Item {
    int id;
    String price_view; // Formatted string to display in view (cell)
    int price_model;   // Raw value for data processing or calculation (controller)

    public Item(int id, String price_view, int price_model) {
        this.id = id;
        this.price_view = price_view;
        this.price_model = price_model;
    }

    @Override
    public String toString() {
        return "Item{" +
               "id=" + id +
               ", price_view='" + price_view + '\'' +
               ", price_model=" + price_model +
               '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Item> result = getItems();
        // You can add code here to use the result as needed
        System.out.println(result);
    }

    public static List<Item> getItems() {
        return Arrays.asList(new Item(1, "$100", 100));
    }
}