import java.util.*;
import java.util.concurrent.*;

public class User_5 {

    static class User {
        private final int id;
        private String name;
        private List<Item> items;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
            this.items = new CopyOnWriteArrayList<>();
        }

        public void addItem(Item item) {
            items.add(item);
        }

        // Getters and setters
    }

    static class Item {
        private final int itemId;
        private String itemName;

        public Item(int itemId, String itemName) {
            this.itemId = itemId;
            this.itemName = itemName;
        }

        // Getters and setters
    }

    public static void main(String[] args) {
    }
}