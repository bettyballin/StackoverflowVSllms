/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class NonNullSetWrapper<E> {
    private Set<E> wrapperSet;

    public boolean addAll(Collection<? extends E> collection) {
        if (null == collection) {
            throw new NullPointerException("c cannot be null");
        }
        if (collection.stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException("c cannot contain nulls");
        }
        return this.wrapperSet.addAll(collection);
    }

    public static void main(String[] stringArray) {
    }
}
