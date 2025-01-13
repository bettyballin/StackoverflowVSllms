import java.lang.String;
import java.util.Arrays;

public class RadixSorter {
    public static void radixSort(int[] arr, int n) {
        int[] output = new int[n];
        int[] count = new int[n];

        // Sort by least significant digit ( LSD )
        for (int i = 0; i < n; i++) {
            int digit = arr[i] % n;
            count[digit]++;
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = arr[i] % n;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Sort by middle digit
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / n) % n;
            count[digit]++;
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / n) % n;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Sort by most significant digit ( MSD )
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            int digit = arr[i] / (n * n);
            count[digit]++;
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = arr[i] / (n * n);
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}