import java.util.List;
import java.util.ArrayList;
/**
 * A wrapper class that stores a List of Integers.
 * For best performance with frequent random access operations (get()), 
 * consider using an ArrayList as its underlying implementation.
 */
public class Wrapper {
    private List<Integer> list;

    public Wrapper(List<Integer> list) {
        this.list = list;
    }

    public Integer get(int index) { return list.get(index); }

    public static void main(String[] args) {
    }
}