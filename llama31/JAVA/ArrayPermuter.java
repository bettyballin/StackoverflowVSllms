import java.lang.String;

public class ArrayPermuter {
    public static void permute(int[] arr, int[] permutation) {
        for (int i = 0; i < arr.length; i++) {
            while (permutation[i] != i) {
                int temp = arr[i];
                arr[i] = arr[permutation[i]];
                arr[permutation[i]] = temp;
                int swap = permutation[i];
                permutation[i] = permutation[swap];
                permutation[swap] = swap;
            }
        }
    }

    public static void main(String[] args) {
    }
}