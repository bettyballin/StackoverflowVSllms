import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class AisleDAOImpl {

    public Aisle fetchAisleWithDetails(Long aisleId) {
        // Assuming a JDBC-based DAO implementation
        String sql = "SELECT * FROM aisle WHERE id = ?";
        // Execute SQL to get AISLE details

        String categorySql = "SELECT * FROM category WHERE aisle_id = ?";
        // Execute SQL to get CATEGORIES for the AISLE

        String itemSql = "SELECT * FROM item WHERE category_id IN (...)";
        // Use a batch or loop if necessary for ITEMS in all categories

        Aisle aisle = new Aisle();
        List<Category> categories = new ArrayList<>();
        Map<Long, Category> categoryMap = new HashMap<>();

        // For illustration, we'll create some dummy categories
        // In real code, categories would be fetched from a database
        Category category1 = new Category();
        category1.setId(1L);
        Category category2 = new Category();
        category2.setId(2L);
        categories.add(category1);
        categories.add(category2);

        // Populate Aisle from AISLE query results
        // Iterate over CATEGORY query results to populate Categories and add them to the Aisle
        for (Category category : categories) {
            category.setAisle(aisle);
            categoryMap.put(category.getId(), category);
        }

        // Populate Items within each Category from ITEM query results
        for (Item item : fetchItems()) { // Assume a method fetchItems() to get all items
            Category parentCategory = categoryMap.get(item.getCategoryId());
            if (parentCategory != null) {
                parentCategory.getItems().add(item);
                item.setCategory(parentCategory); // Set the Category reference in Item
            }
        }

        aisle.setCategories(categories);

        return aisle;
    }

    private List<Item> fetchItems() {
        // Dummy implementation
        List<Item> items = new ArrayList<>();
        // For example, create some dummy items
        Item item1 = new Item();
        item1.setCategoryId(1L);
        Item item2 = new Item();
        item2.setCategoryId(2L);
        items.add(item1);
        items.add(item2);
        return items;
    }

    public static void main(String[] args) {
        AisleDAOImpl dao = new AisleDAOImpl();
        Aisle aisle = dao.fetchAisleWithDetails(1L);
        // For testing purposes, you can print out the result
        System.out.println("Aisle categories count: " + aisle.getCategories().size());
    }
}

class Aisle {
    private List<Category> categories;

    public Aisle() {
        // constructor
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return this.categories;
    }
}

class Category {
    private Long id;
    private Aisle aisle;
    private List<Item> items;

    public Category() {
        items = new ArrayList<>();
    }

    public void setAisle(Aisle aisle) {
        this.aisle = aisle;
    }

    public Aisle getAisle() {
        return aisle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

class Item {
    private Long categoryId;
    private Category category;

    public Item() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}