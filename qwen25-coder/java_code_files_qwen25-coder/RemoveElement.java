import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Remove element at index 1 ("Banana")
        list.remove(1);

        System.out.println(list);  // Output: [Apple, Cherry]
    }
}