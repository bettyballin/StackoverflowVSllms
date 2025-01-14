import java.lang.String;
import java.util.Comparator;

public class Foo_6 {

    class Foo {
        String bar;
        // other fields...

        public Foo(String bar) {
            this.bar = bar;
        }
    }

    private static class BarComparator implements Comparator<Foo> {
        @Override
        public int compare(Foo o1, Foo o2) {
            return Comparator.nullsFirst(
                    Comparator.comparing((Foo foo) -> foo.bar, Comparator.nullsFirst(Comparator.naturalOrder()))
            ).compare(o1, o2);
        }
    }

    public static void main(String[] args) {
    }
}