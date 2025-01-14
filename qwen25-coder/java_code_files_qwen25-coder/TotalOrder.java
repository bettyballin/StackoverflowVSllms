import java.lang.String;
import java.lang.Integer;
import java.util.Comparator;

public class TotalOrder {

    class TotalOrder<T> implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            if (o1 == o2 || equal(o1, o2)) return 0;
            // Compare based on identity hash code
            int h1 = System.identityHashCode(o1);
            int h2 = System.identityHashCode(o2);
            // Avoid overflow and unnecessary computations for small differences
            if (h1 != h2) {
                return Integer.compare(h1, h2);
            }
            // If identity hash codes are the same, compare based on object reference
            return System.identityHashCode(Thread.currentThread()) % 2 == 0 ? o1.hashCode() : -o1.hashCode();
        }

        boolean equal(T o1, T o2) {
            return (o1 == null && o2 == null) || (o1 != null && o1.equals(o2));
        }
    }

    public static void main(String[] args) {
    }
}