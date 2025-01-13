import java.util.Arrays;
import java.util.List;

public class Main_137 {
    public static void main(String[] args) {
        List<Integer> sortedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int index = binarySearch(sortedList, 5);
        System.out.println(index); // output: 4
    }

    public static int binarySearch(List<Integer> sortedList, int target) {
        int low = 0;
        int high = sortedList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = sortedList.get(mid);

            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // not found
    }
}