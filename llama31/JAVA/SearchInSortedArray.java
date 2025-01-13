import java.lang.String;
import java.util.Arrays;
import java.util.Random;

public class SearchInSortedArray {
    public static void main(String[] args) {
        int[] array = getSortedArray(10);

        int target = 7;
        int index = Arrays.binarySearch(array, target);

        System.out.println("Array is " + Arrays.toString(array));
        System.out.println("Index of " + target + " is " + index);
    }

    private static int[] getSortedArray(int n) {
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n * 10);
        }
        Arrays.sort(array);
        return array;
    }
}