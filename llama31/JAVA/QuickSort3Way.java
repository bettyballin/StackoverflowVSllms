import java.lang.String;
public class QuickSort3Way {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = arr[lo];
        int lt = lo + 1; // less than pivot
        int gt = hi;     // greater than pivot
        int i = lo + 1;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, i, lt);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, lo, lt - 1);
        sort(arr, lo, lt - 2);
        sort(arr, gt + 1, hi);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

	public static void main(String[] args) {
	}
}