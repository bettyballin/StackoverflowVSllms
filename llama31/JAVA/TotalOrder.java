import java.util.Comparator;

public class TotalOrder implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == o2) {
            return 0;
        }

        if (o1 == null) {
            return -1;
        }

        if (o2 == null) {
            return 1;
        }

        int h1 = System.identityHashCode(o1);
        int h2 = System.identityHashCode(o2);

        if (h1 != h2) {
            return h1 < h2 ? -1 : 1;
        }

        // If we reach this point, o1 and o2 have the same identity hash code
        // but are not equal. We need to break the tie in a consistent manner.
        // One way to do this is to compare their string representations.
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s1.compareTo(s2);
    }

    public static void main(String[] args) {
    }
}