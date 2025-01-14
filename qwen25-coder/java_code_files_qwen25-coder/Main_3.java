import java.util.ArrayList;
import java.util.List;

public class Main_3 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.remove(Integer.valueOf(3));  // Removes the first occurrence of 3
        // or
        myList.remove((int) 2);  // Removes the element at index 2 (which is 3)
    }
}