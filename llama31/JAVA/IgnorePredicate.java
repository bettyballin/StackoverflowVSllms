import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.NotNullPredicate;

public class IgnorePredicate<T> implements Predicate<T> {
    private final Predicate<T> delegate;

    public IgnorePredicate(Predicate<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean evaluate(T object) {
        try {
            return delegate.evaluate(object);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Predicate<String> notNullPredicate = new NotNullPredicate<>();
        IgnorePredicate<String> ignorePredicate = new IgnorePredicate<>(notNullPredicate);
        System.out.println(ignorePredicate.evaluate("Hello"));  // prints: true
        System.out.println(ignorePredicate.evaluate(null));  // prints: false
    }
}