import java.util.Arrays;

public class Timsort {
    private static final int MIN_MERGE = 32;

    public static void sort(int[] array) {
        int n = array.length;
        int minRun = minRunLength(n);

        for (int i = 0; i < n; i += minRun) {
            insertionSort(array, i, Math.min(i + minRun - 1, n - 1));
        }

        for (int size = minRun; size < n; size *= 2) {
            for (int left = 0; left < n; left += size * 2) {
                int mid = left + size - 1;
                int right = Math.min(left + size * 2 - 1, n - 1);

                merge(array, left, mid, right);
            }
        }
    }

    private static int minRunLength(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= n & 1;
            n >>= 1;
        }
        return n + r;
    }

    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

	public static void main(String[] args) {
		int[] array = {4, 2, 9, 6, 23, 12, 34, 0, 1};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}