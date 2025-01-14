import java.util.Set;
import java.util.HashSet;
public class SingletonSetAccessor {
    Set<String> set = new HashSet<>();
    // Assume the set has been populated with a single item
    String singleElement = set.iterator().next();

    public static void main(String[] args) {
    }
}