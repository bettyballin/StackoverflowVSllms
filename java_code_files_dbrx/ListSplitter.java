import java.util.ArrayList;
import java.util.List;

public class ListSplitter {
    public static <T> List<T> split(List<T> list, int i) {
        if (i < 0 || i >= list.size()) { // optional: ensure that i is within bounds of the original list
            throw new ArrayIndexOutOfBoundsException("Invalid split point: " + i);
        }
        List<T> sub1 = new ArrayList<>(list.subList(0, i)); // copy first part as a standalone list (optional)
        return sub1;
    }
    public static void main(String[] args) {
    }
}