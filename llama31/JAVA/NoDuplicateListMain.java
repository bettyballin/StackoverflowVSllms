import java.util.*;

// Define a NoDuplicateList class that ensures no duplicates are added
class NoDuplicateList<T> {
    private final Set<T> set = new HashSet<>();
    private final List<T> list = new ArrayList<>();

    public boolean add(T element) {
        if (set.add(element)) {
            list.add(element);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

public class NoDuplicateListMain {
    public static void main(String[] args) {
        NoDuplicateList<String> list = new NoDuplicateList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");  // this will not be added
        System.out.println(list);  // prints [apple, banana]
    }
}