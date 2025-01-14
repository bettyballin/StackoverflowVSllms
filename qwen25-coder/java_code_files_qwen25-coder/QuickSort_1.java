import java.lang.String;
public class QuickSort_1 {
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);  // Before pi
            quickSort(array, pi + 1, high); // After pi
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}