import java.util.Comparator;
import java.util.Objects;

public class BarComparator_1 {
    private static final class BarComparator implements Comparator<Foo> {
        @Override
        public int compare(final Foo o1, final Foo o2) {
            return Objects.compare(o1 != null ? o1.getBar() : "",
                                   o2 != null ? o2.getBar() : "", String::compareTo);
        }
    }

    public static void main(String[] args) {
    }
}

interface Foo {
    String getBar();
}