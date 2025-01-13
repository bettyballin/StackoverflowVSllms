import java.util.Comparator;
import java.util.Objects;

class Foo {
    String bar;
}

public class BarComparator implements Comparator<Foo> {
    public int compare(final Foo o1, final Foo o2) {
        return Objects.compare(o1.bar, o2.bar, String.CASE_INSENSITIVE_ORDER);
    }

    public static void main(String[] args) {
    }
}