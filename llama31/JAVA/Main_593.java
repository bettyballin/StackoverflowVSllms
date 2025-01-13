import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main_593_593 {
    public static void main(String[] args) {
        // Create an ArrayList
        List<Object> list = new ArrayList<>();

        // Add elements to the list
        for (int i = 0; i < 100; i++) {
            list.add(i); // Example object, replace with your actual object
        }

        // Read elements using an iterator
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.println(element);
        }

        // "Destroy" the list by removing all references to it
        list = null;
    }
}