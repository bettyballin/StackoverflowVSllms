import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final List<String> VALID_CATEGORIES = Arrays.asList("inflammable", "Fragile");

    public static boolean isValidCategory(String category) {
        return VALID_CATEGORIES.contains(category);
    }

    public static void main(String[] args) {
    }
}