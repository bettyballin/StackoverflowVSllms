import java.lang.String;

public class BinarySearchUtil_1_1 {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Avoid integer overflow
            int mid = low + (high - low) / 2;

            // Correct comparison
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // Correct update logic
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Handle not found case
        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int result = binarySearch(arr, target);
        if (result == -1) {
            System.out.println("Element not found in the array");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}