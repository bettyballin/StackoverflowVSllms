import java.util.List;

public class BinarySearchUtil {
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

    public static void main(String[] args) {
        // Example usage:
        // List<Integer> sortedList = Arrays.asList(1, 2, 3, 4, 5);
        // int target = 3;
        // int result = binarySearch(sortedList, target);
        // System.out.println("Result: " + result);
    }
}