import java.util.ArrayList;
import java.util.List;

public class Main_241 {
    public static int binarySearch(List<Integer> list, int x) {
        Integer temp = null;
        int lb = 0, ub = list.size() - 1;
        while (lb <= ub) {
            int mid = lb + ((ub - lb) / 2);
            temp = list.get(mid);
            if (temp == x) {
                return mid;
            } else if (temp < x) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        return -1; // If 'x' was not found in the List.
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(5, 7, 13, 20));
        int x = 99;
        int result = binarySearch(list, x);
        // Check if element 'x' is found in a list and print index accordingly:
        System.out.println((result < 0) ? "Element not present" : "Element found at index " + ++result);
    }
}