import java.util.ArrayList;
import java.util.function.Predicate;

public class IgnoringPredicatedList<E> extends ArrayList<E> {
    private final Predicate<? super E> predicate;

    public IgnoringPredicatedList(Predicate<? super E> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean add(E element) {
        if (predicate.test(element)) {
            return super.add(element);
        } else {
            // Ignore elements that do not match the predicate
            return false;
        }
    }
}

// Usage example:
public class Main {
    public static void main(String[] args) {
        IgnoringPredicatedList<String> list = new IgnoringPredicatedList<>(o -> o != null);

        list.add("Hello");
        list.add(null); // This will be ignored

        System.out.println(list.size()); // Output: 1
    }
}