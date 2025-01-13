import java.util.List;

public class Aisle_2 {
    private List<Category> categories;
    private List<Item> items;
    // getters and setters
}

class Category {
    private Aisle aisle;
    private List<Item> items;
    // getters and setters
}

class Item {
    private Category category;
    // getters and setters

    public static void main(String[] args) {
    }
}