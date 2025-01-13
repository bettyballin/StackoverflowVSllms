import java.util.ArrayList;

public class ListRearranger {

    public static void moveElement(ArrayList<String> list, int index, boolean moveUp) {
        if (list.isEmpty() || index < 0 || index >= list.size()) {
            return; // Invalid conditions
        }

        int newIndex = moveUp ? index - 1 : index + 1;

        // Check boundaries
        if (newIndex < 0 || newIndex >= list.size()) {
            return; // Out of bounds
        }

        // Swap elements
        String temp = list.get(index);
        list.set(index, list.get(newIndex));
        list.set(newIndex, temp);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("Original List: " + list);

        moveElement(list, 1, true); // Move "B" up
        System.out.println("List after moving 'B' up: " + list);

        moveElement(list, 2, false); // Move "C" down
        System.out.println("List after moving 'C' down: " + list);
    }
}