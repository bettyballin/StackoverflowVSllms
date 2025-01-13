/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class AisleDAO {
    public Aisle getAisle(int n) {
        Aisle aisle = new Aisle();
        aisle.setId(n);
        aisle.setCategories(this.loadCategoriesForAisle(aisle));
        return aisle;
    }

    private List<Category> loadCategoriesForAisle(Aisle aisle) {
        return null;
    }
}
