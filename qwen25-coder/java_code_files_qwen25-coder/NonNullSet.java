import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NonNullSet<E> implements Set<E> {
    private final Set<E> innerSet;

    public NonNullSet() {
        this.innerSet = new HashSet<>();
    }

    @Override
    public int size() {
        return innerSet.size();
    }

    @Override
    public boolean isEmpty() {
        return innerSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return innerSet.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return innerSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return innerSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return innerSet.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
        return innerSet.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return innerSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return innerSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            if (e == null) {
                throw new NullPointerException("Null elements are not allowed");
            }
        }
        return innerSet.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return innerSet.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return innerSet.removeAll(c);
    }

    @Override
    public void clear() {
        innerSet.clear();
    }

    public static void main(String[] args) {
    }
}