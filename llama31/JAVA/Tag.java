import java.util.Hashtable;

public class Tag {
    // Generalized storage using a Hashtable
    private Hashtable<String, String> attributes;

    public Tag() {
        attributes = new Hashtable<>();
    }

    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public static void main(String[] args) {
    }
}