/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

class CategoryDAO {
    CategoryDAO() {
    }

    public Category getCategory(int n) {
        Category category = new Category();
        category.setId(n);
        category.setItems(this.loadItemsForCategory(category));
        return category;
    }

    private List<Item> loadItemsForCategory(Category category) {
        return null;
    }
}
