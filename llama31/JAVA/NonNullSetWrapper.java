import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class NonNullSetWrapper<E> {
    private Set<E> wrapperSet;

    public boolean addAll(Collection<? extends E> c) {
        if (null == c) {
            throw new NullPointerException("c cannot be null");
        }

        if (c.stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException("c cannot contain nulls");
        }

        return this.wrapperSet.addAll(c);
    }

    public static void main(String[] args) {
    }
}