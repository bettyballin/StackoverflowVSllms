/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NoDuplicateList<T> {
    private final Set<T> set = new HashSet<T>();
    private final List<T> list = new ArrayList<T>();

    NoDuplicateList() {
    }

    public boolean add(T t) {
        if (this.set.add(t)) {
            this.list.add(t);
            return true;
        }
        return false;
    }

    public String toString() {
        return this.list.toString();
    }
}
