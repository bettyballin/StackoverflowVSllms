import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListExample {
    public static void main(String[] args) {
        // Using ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Element 1");
        arrayList.add("Element 2"); // Element at index: 1
        arrayList.add(1, "Inserted Element"); // Inserting at index 1

        // Using LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Element 1");
        linkedList.add("Element 2"); // Element at index: 1
        linkedList.add(1, "Inserted Element"); // Efficient insertion at index 1

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }
}