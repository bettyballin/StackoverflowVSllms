import java.lang.String;
import java.util.Arrays;

public class LinearTimeSort {
    public static void countingSort(int[] array) {
        if (array.length == 0) return;
        
        int n = array.length;
        // The maximum possible value is n^3 - 1, but since we use inclusive ranges, the size of count array is n^3.
        int max = n * n * n;
        int[] countArray = new int[max];
        
        // Populate count array
        for (int num : array) {
            countArray[num]++;
        }
        
        // Write sorted array
        int index = 0;
        for (int i = 0; i < max; i++) {
            while (countArray[i] > 0) {
                array[index++] = i;
                countArray[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // Example value for n
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}; // Example array with values in [0..n^3-1]
        
        countingSort(array);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}