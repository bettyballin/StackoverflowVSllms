import java.util.Comparator;
import java.util.Optional;

class Foo {
    String bar;
}

public class BarComparator_2_2 {

    private static class BarComparator implements Comparator<Foo> {
        public int compare(final Foo o1, final Foo o2) {
            return Optional.ofNullable(o1.bar)
                    .orElse("")
                    .compareToIgnoreCase(Optional.ofNullable(o2.bar).orElse(""));
        }
    }

    public static void main(String[] args) {
    }
}