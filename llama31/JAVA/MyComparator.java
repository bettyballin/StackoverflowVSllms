import java.util.Comparator;

public class MyComparator {
    static class MyComparatorInner implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.toUpperCase().compareTo(b.toUpperCase());
        }
    }

    public static void main(String[] args) {
    }
}