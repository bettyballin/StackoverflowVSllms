public class ItemLoaderWithCategoryRetrieval {
    // Example in Java: Fetching item and category separately
    public static void main(String[] args) {
        int itemId = 42; // Example itemId
        ItemRepository itemRepository = new ItemRepository();
        CategoryRepository categoryRepository = new CategoryRepository();

        Item item = itemRepository.findItemById(itemId);
        Category category = categoryRepository.getCategoryById(item.getCategoryId());
        item.setCategoryName(category.getName());

        // For demonstration, print out the category name
        System.out.println("Item's category name is: " + item.getCategoryName());
    }
}

class Item {
    private int categoryId;
    private String categoryName;

    public Item(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ItemRepository {
    public Item findItemById(int itemId) {
        // Dummy implementation
        return new Item(1); // Assume categoryId is 1
    }
}

class CategoryRepository {
    public Category getCategoryById(int categoryId) {
        // Dummy implementation
        return new Category("Category " + categoryId);
    }
}