import java.util.*;

public class Splitter {
    public static <T> List<T> split(List<T> list, int i) {
        if (i < 0 || i >= list.size()) { // optional: ensure that i is within bounds of the original list
            throw new ArrayIndexOutOfBoundsException("Invalid split point: " + i);
        }
        List<T> sub1 = new ArrayList<>(list.subList(0, i)); // copy first part as a standalone list (optional)
        for (int j = i; j < list.size(); ++j) { // remove elements from original list until it reaches desired size
            list.remove(i);
        }
        return sub1;
    }
}