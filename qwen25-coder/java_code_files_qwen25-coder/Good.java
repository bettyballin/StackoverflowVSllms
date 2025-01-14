import java.util.Set;

public class Good {

    private String category;

    public Good(String category) {
        validateCategory(category);
        this.category = category;
    }

    private void validateCategory(String category) {
        if (category == null || !allowedCategories().contains(category)) {
            throw new IllegalArgumentException("Invalid or missing Category");
        }
    }
    
    private Set<String> allowedCategories() {
        // Retrieve from a static list or database
        return Set.of("inflammable", "fragile");
    }

}