import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Example_11 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        // Adding elements
        for (int i = 0; i < 100; i++) {
            list.add(new Object());
        }

        // Reading elements with an iterator
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
        }

        // No need to explicitly destroy the list, it goes out of scope and will be garbage collected.
    }
}