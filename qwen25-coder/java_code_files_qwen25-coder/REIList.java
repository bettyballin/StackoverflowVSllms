import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class REIList<T> implements List<T> {
    private Class<T> klass;
    private List<T> elements = new ArrayList<>();

    public REIList(Class<T> klass) {
        this.klass = klass;
    }

    // Method implementation with checks against 'klass'
    @Override
    public boolean add(T t) {
        if (!klass.isInstance(t)) {
            throw new IllegalArgumentException("Type does not match");
        }
        return elements.add(t);
    }

    @Override
    public void add(int index, T element) {
        if (!klass.isInstance(element)) {
            throw new IllegalArgumentException("Type does not match");
        }
        elements.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            if (!klass.isInstance(element)) {
                throw new IllegalArgumentException("Type does not match in addAll()");
            }
        }
        return elements.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T element : c) {
            if (!klass.isInstance(element)) {
                throw new IllegalArgumentException("Type does not match in addAll()");
            }
        }
        return elements.addAll(index, c);
    }

    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public T get(int index) {
        return elements.get(index);
    }

    @Override
    public int indexOf(Object o) {
        return elements.indexOf(o);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        return elements.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return elements.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return elements.listIterator(index);
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public T remove(int index) {
        return elements.remove(index);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return elements.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return elements.retainAll(c);
    }

    @Override
    public T set(int index, T element) {
        if (!klass.isInstance(element)) {
            throw new IllegalArgumentException("Type does not match");
        }
        return elements.set(index, element);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return elements.subList(fromIndex, toIndex);
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public <E> E[] toArray(E[] a) {
        return elements.toArray(a);
    }

    public static void main(String[] args) {
        // Test the REIList
        REIList<String> list = new REIList<>(String.class);
        list.add("Hello");
        System.out.println(list.get(0));
    }
}