import java.util.List;

public class Aisle {
    private List<Item> items;
    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }
}

class Item {
    private Aisle aisle;
    private Category category;
    public Aisle getAisle() { return aisle; }
    public void setAisle(Aisle aisle) { this.aisle = aisle; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}

class Category {
    private List<Item> items;
    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    public static void main(String[] args) {
    }
}