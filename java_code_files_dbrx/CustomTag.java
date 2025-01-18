import java.util.HashMap;
import java.util.Map;

public class CustomTag {
    private Map<String, Object> attributes = new HashMap<>();

    // Instead of defining multiple fields with their own getters and setters...
    // private String attr1;
    // ... individual attribute methods look like this:

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public static void main(String[] args) {
    }
}