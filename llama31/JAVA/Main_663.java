import java.util.Arrays;

public class Main_663 {
    public static void main(String[] args) {
        int[] arr = {45, 89, 22, 31, 23, 76};
        int[] permutation = {5, 3, 2, 1, 0, 4};

        permute(arr, permutation);

        System.out.println(Arrays.toString(arr)); // [76, 31, 22, 89, 45, 23]
    }

    public static void permute(int[] arr, int[] permutation) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[permutation[i]];
        }
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }
}