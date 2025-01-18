import java.lang.String;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class BarComparator implements Comparator<Foo> {
    @Override
    public int compare(final Foo o1, final Foo o2) {
        return Optional.ofNullable(o1).map(Foo::getBar).orElse("")
            .compareTo(Optional.ofNullable(o2).map(Foo::getBar).orElse(""));
    }
    public static void main(String[] args) {
    }
}

class Foo {
    public String getBar() {
        return "";
    }
}