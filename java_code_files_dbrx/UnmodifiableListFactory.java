import java.util.List;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.Collections;

public class UnmodifiableListFactory {
    private final List<String> readOnlyCollection = Collections.unmodifiableList(createBaseList());

    private List<String> createBaseList() {
        List<String> list = new ArrayList<>();
        // populate the list
        list.add("item1");
        list.add("item2");
        return list;
    }

    public static <T> List<T> unmodifiableList(List<? extends T> list) {
        return (list instanceof RandomAccess ? new UnmodifiableRandomAccessList<>(list) :
                new UnmodifiableList<>(list));
    }

    public static void main(String[] args) {
    }

    // Inner classes definitions
    private static class UnmodifiableList<E> extends AbstractList<E> {
        final List<? extends E> list;

        UnmodifiableList(List<? extends E> list) {
            this.list = list;
        }

        public E get(int index) {
            return list.get(index);
        }

        public int size() {
            return list.size();
        }

        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private final Iterator<? extends E> i = list.iterator();

                public boolean hasNext() {
                    return i.hasNext();
                }

                public E next() {
                    return i.next();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public boolean contains(Object o) {
            return list.contains(o);
        }
    }

    private static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        UnmodifiableRandomAccessList(List<? extends E> list) {
            super(list);
        }
    }
}