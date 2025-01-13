import java.util.Comparator;

public class ArrayIntersectionChecker_1_1 {
    public static <T> boolean intersect(T[] a, T[] b, Comparator<T> comparator) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int cmp = comparator.compare(a[i], b[j]);
            if (cmp < 0) {
                i++;
            } else if (cmp > 0) {
                j++;
            } else {
                return true; // found an intersection
            }
        }
        return false; // no intersection found
    }

    public static void main(String[] args) {
    }
}