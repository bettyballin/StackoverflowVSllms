import java.util.List;

public class Order_3 {
    class Order {
        private int id;
        private List<Item> items; // OO perspective: Order has many Items

        public List<Item> getItems() { return this.items; }
    }

    class Item {
        private int id;
        private String name;
    }

    // SQL Perspective:
    // Orders table with columns (id)
    // Items table with columns (id, name, order_id) where order_id is a foreign key referencing Orders(id)

    public static void main(String[] args) {
    }
}