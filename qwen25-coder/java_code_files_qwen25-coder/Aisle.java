import java.util.List;

// Aisle class
class Aisle {
    private Long id;
    private String description;
    private List<Category> categories;

    // Constructors, getters, setters, and methods
}

// Category class
class Category {
    private Long id;
    private String name;
    private List<Item> items;
    private Aisle aisle; // Reference to the parent Aisle

    // Constructors, getters, setters, and methods
}

// Item class
public class Item {
    private Long id;
    private String name;
    private String description;
    private Category category;

    // Constructors, getters, setters, and methods

    public static void main(String[] args) {
    }
}