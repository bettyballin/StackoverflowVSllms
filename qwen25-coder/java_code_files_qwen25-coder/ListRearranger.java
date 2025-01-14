import java.util.ArrayList;
import java.util.Collections;

public class ListRearranger {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("Original List: " + list);

        int indexToMove = 2; // Index of the element to move
        boolean moveForward = true; // Set to false for moving backward

        if (moveForward) {
            swapWithNext(list, indexToMove);
        } else {
            swapWithPrevious(list, indexToMove);
        }

        System.out.println("Modified List: " + list);
    }

    public static void swapWithNext(ArrayList<?> list, int index) {
        if (index >= 0 && index < list.size() - 1) {
            Collections.swap(list, index, index + 1);
        }
    }

    public static void swapWithPrevious(ArrayList<?> list, int index) {
        if (index > 0 && index <= list.size()) {
            Collections.swap(list, index, index - 1);
        }
    }
}