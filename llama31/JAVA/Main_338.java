import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main_338 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String current = iterator.next();
            if (current.equals("B")) {
                iterator.set("X"); // replace "B" with "X"
            }
        }

        System.out.println(list); // prints [A, X, C]
    }
}