import java.lang.String;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.*;

public class Main_32 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-1, 0, 1, 2)); // Sample data

        int indexToMove = 2;                      // Index of the element you want to move
        int distance = -1;                         // Distance to move (negative for forward and positive for backward)

        Collections.swap(list, indexToMove + distance, indexToMove);   // Swap elements at given indices
    }
}