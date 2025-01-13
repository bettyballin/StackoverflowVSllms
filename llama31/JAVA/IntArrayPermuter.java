import java.lang.String;

public class IntArrayPermuter {
    public static void permute(int[] T) {
        int n = T.length;
        for (int i = 0; i < n; i++) {
            int j = T[i];
            while (j < i) {
                int temp = T[j];
                T[j] = T[i];
                T[i] = temp;
                j = T[i];
            }
        }
    }

    public static void main(String[] args) {
        // Add some test code to demonstrate the functionality
        int[] array = {3, 1, 2, 0};
        System.out.println("Before permutation:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        permute(array);
        System.out.println("\nAfter permutation:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}