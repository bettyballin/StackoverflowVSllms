/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import java.util.Objects;

public class BarComparator
implements Comparator<Foo> {
    @Override
    public int compare(Foo foo, Foo foo2) {
        return Objects.compare(foo.bar, foo2.bar, String.CASE_INSENSITIVE_ORDER);
    }

    public static void main(String[] stringArray) {
    }
}
