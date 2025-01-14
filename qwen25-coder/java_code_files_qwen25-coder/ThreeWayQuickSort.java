import java.lang.String;
public class ThreeWayQuickSort {
    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int low, int high) {
        if (low >= high) return;
        
        int lt = low; // Less than pointer
        int gt = high; // Greater than pointer
        int pivot = arr[low]; // Pivot element
        int i = low;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, gt--, i);
            } else {
                i++;
            }
        }

        quicksort(arr, low, lt - 1);
        quicksort(arr, gt + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 3, 7, 2, 8, 1, 6, 5, 5};
        quicksort(array);
        System.out.println("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}