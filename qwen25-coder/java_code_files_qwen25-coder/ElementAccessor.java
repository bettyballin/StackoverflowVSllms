import java.util.Set;
import java.util.HashSet;

public class ElementAccessor {
    Set<String> set = new HashSet<>();
    // Assume set is populated
    String firstElement = set.iterator().next();

    public static void main(String[] args) {
    }
}