import java.util.HashSet;

public class NonNullHashSet<T> extends HashSet<T> {
    @Override
    public boolean add(T t) {
        if (t == null) {
            throw new NullPointerException("Cannot add null to this set");
        }
        return super.add(t);
    }

    public static void main(String[] args) {
        NonNullHashSet<String> set = new NonNullHashSet<>();
        set.add("hello"); // works fine
        try {
            set.add(null); // throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}