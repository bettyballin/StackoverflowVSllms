import java.lang.String;

public class QuickSort {
    public QuickSort(int[] arr) {
        // Add some code here to sort the array using QuickSort algorithm
        // For now, it's just printing the array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort(new int[] {8, 12, 79, 12, 50, 44, 8, 0, 7, 289, 1});
    }
}