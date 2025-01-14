import java.lang.String;
public class BinarySearcher_1 {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // To avoid potential overflow, use this method to calculate mid-point
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Target not found
    }
    public static void main(String[] args) {
    }
}