import java.util.*;

public class NoDuplicateList<E> extends ArrayList<E> {

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        if (!contains(element)) {
            super.add(index, element);
        }
    }

    public boolean addAll(Collection<? extends E> c) {
        List<E> toAdd = new ArrayList<>();
        for (E e : c) {
            if (!contains(e)) {
                toAdd.add(e);
            }
        }
        return super.addAll(toAdd);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        List<E> toAdd = new ArrayList<>();
        for (E e : c) {
            if (!contains(e)) {
                toAdd.add(e);
            }
        }
        return super.addAll(index, toAdd);
    }

    public static void main(String[] args) {
    }
}