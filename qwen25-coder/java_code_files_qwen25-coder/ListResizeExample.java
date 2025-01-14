import java.util.ArrayList;

public class ListResizeExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(2); // Initial capacity 2
        System.out.println("Initial Capacity: " + list.size());

        // Adding elements
        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println("Size after adding element " + i + ": " + list.size());
        }
    }
}