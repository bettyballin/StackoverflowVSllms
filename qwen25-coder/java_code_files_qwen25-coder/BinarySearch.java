import java.lang.String;
public class BinarySearch {
    // Method to perform binary search on a sorted array
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow

            // Check if the target is present at mid
            if (array[mid] == target) {
                return mid; // Target found
            }

            // If target greater, ignore left half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 3, 4, 10, 40};
        int target = 10;

        int result = binarySearch(sortedArray, target);

        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}