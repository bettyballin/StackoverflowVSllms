import java.util.Map;
import java.util.HashMap;

public class HashConsExample {
    private static final Map<String, HashConsExample> cache = new HashMap<>();

    private final String value;

    private HashConsExample(String value) {
        this.value = value;
    }

    public static HashConsExample getInstance(String value) {
        return cache.computeIfAbsent(value, HashConsExample::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashConsExample that = (HashConsExample) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public static void main(String[] args) {
        // You can add your test code here
        HashConsExample example1 = getInstance("Hello");
        HashConsExample example2 = getInstance("Hello");
        System.out.println(example1 == example2); // prints: true
    }
}