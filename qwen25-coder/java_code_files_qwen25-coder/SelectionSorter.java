import java.lang.String;
public class SelectionSorter {
    public void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Assume the minimum is the first element
            int minIndex = i;
            // Test against elements after i to find the smallest
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    // If a new minimum is found, remember its index
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = array[i]; // Using one extra variable for swapping
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    public static void main(String[] args) {
    }
}