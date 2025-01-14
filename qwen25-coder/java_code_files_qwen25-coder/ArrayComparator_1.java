import java.util.HashSet;
import java.util.Set;

public class ArrayComparator_1 {
    public static boolean compare(Object[] array1, Object[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        Set<Object> set1 = new HashSet<>();
        for (Object obj : array1) {
            set1.add(obj);
        }

        for (Object obj : array2) {
            if (!set1.contains(obj)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(compare(new Object[]{"a", "b", "c", "d"}, new Object[]{"b", "a", "d", "c"})); // true
        System.out.println(compare(new Object[]{"a", "b", "e"}, new Object[]{"a", "b", "c"})); // false
        System.out.println(compare(new Object[]{"a", "b", "c"}, new Object[]{"a", "b"})); // false
    }
}