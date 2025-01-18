import java.lang.String;
import java.util.*;

public class TotalOrder {
    class TotalOrder<T> implements Comparator<T> {
        public int compare(T o1, T o2) {
            if (o1 == o2 || equal(o1, o2)) return 0; // If the objects are same/equal just return 0 and consider them as equivalent in ordering.

            // Get Identity HashCode of both Objects
            int h1 = System.identityHashCode(o1);
            int h2 = System.identityHashCode(o2);

            if (h1 != h2) {
                return h1 < h2 ? -1 : 1; // If the hashcodes are not equal, then use them to order objects.
            } else {
                throw new IllegalStateException("Inconsistent Java Runtime"); // Two unique instances having same identityHashCode should never happen in a single JVM.
            }
        }

        boolean equal(Object o1, Object o2) {
            return o1 == null ? o2 == null : o1.equals(o2);
        }
    }
    public static void main(String[] args) {
    }
}