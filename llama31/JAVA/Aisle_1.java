import java.util.List;

public class Aisle_1 {
    private List<Category> categories;
    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
}

class Category {
    private Aisle aisle;
    private List<Item> items;
    public Aisle getAisle() { return aisle; }
    public void setAisle(Aisle aisle) { this.aisle = aisle; }
    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }
}

class Item {
    private Category category;
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public static void main(String[] args) {}
}