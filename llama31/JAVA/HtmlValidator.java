import java.util.HashSet;
import java.util.Set;

public class HtmlValidator {
    private static final Set<String> ALLOWED_ATTRIBUTES = new HashSet<>();
    static {
        ALLOWED_ATTRIBUTES.add("style");
        ALLOWED_ATTRIBUTES.add("href");
    }

    private static final Set<String> ALLOWED_STYLES = new HashSet<>();
    static {
        ALLOWED_STYLES.add("color");
        ALLOWED_STYLES.add("background-color");
        // Add more allowed styles as needed
    }

    public boolean isValidAttribute(String attributeName, String attributeValue) {
        if (!ALLOWED_ATTRIBUTES.contains(attributeName)) {
            return false;
        }

        if (attributeName.equals("style")) {
            String[] styles = attributeValue.split(";");
            for (String style : styles) {
                String[] styleParts = style.split(":");
                if (styleParts.length != 2 || !ALLOWED_STYLES.contains(styleParts[0].trim())) {
                    return false;
                }
            }
        }

        // Additional validation for other attributes can be added here
        return true;
    }

    public static void main(String[] args) {
        HtmlValidator validator = new HtmlValidator();
        System.out.println(validator.isValidAttribute("style", "color: red; background-color: blue"));  // prints: true
        System.out.println(validator.isValidAttribute("style", "color: red; invalid-style: blue"));  // prints: false
        System.out.println(validator.isValidAttribute("href", "https://www.example.com"));  // prints: true
        System.out.println(validator.isValidAttribute("invalid-attribute", "value"));  // prints: false
    }
}