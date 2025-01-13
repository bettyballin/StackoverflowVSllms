import java.util.*;

public class NoDuplicateList<T> extends ArrayList<T> {
    private Set<T> set = new HashSet<>();

    @Override
    public boolean add(T t) {
        if (set.add(t)) {
            return super.add(t);
        }
        return false;
    }

    @Override
    public void add(int index, T element) {
        if (set.add(element)) {
            super.add(index, element);
        } else {
            throw new IllegalArgumentException("Duplicate element");
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = false;
        for (T t : c) {
            if (add(t)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean result = false;
        for (T t : c) {
            try {
                add(index, t);
                index++;
                result = true;
            } catch (IllegalArgumentException e) {
                // ignore duplicate element
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NoDuplicateList<String> list = new NoDuplicateList<>();
        System.out.println(list.add("Hello"));  // prints: true
        System.out.println(list.add("World"));  // prints: true
        System.out.println(list.add("Hello"));  // prints: false
        try {
            list.add(0, "Hello");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // prints: Duplicate element
        }
    }
}