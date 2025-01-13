import java.util.Comparator;

class Foo {
    String bar;
}

public class BarComparator_1_1 {
    private static class BarComparator implements Comparator<Foo> {
        public int compare(final Foo o1, final Foo o2) {
            if (o1.bar == null && o2.bar == null) return 0;
            if (o1.bar == null) return -1;
            if (o2.bar == null) return 1;
            return o1.bar.compareToIgnoreCase(o2.bar);
        }
    }

    public static void main(String[] args) {
    }
}