import java.lang.String;
public class BinarySearcher {
    int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
    public static void main(String[] args) {
    }
}